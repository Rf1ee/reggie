package com.f1ee.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.f1ee.reggie.common.R;
import com.f1ee.reggie.entity.User;
import com.f1ee.reggie.service.UserService;
import com.f1ee.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Flee
 * @date 2022/11/10 14:28
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSenderImpl mailSender;


    @Autowired
    private StringRedisTemplate redisTemplate;
    /**
     * 发送手机验证码
     * @param user
     * @return
     */
    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session) {
        //获取手机号
        String phone = user.getPhone();
        log.info(phone);
        //定制纯文本邮件信息SimpleMailMessage
        if (StringUtils.isNotEmpty(phone)) {
            SimpleMailMessage message = new SimpleMailMessage();
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info(code);
            //发件人地址
            message.setFrom(from);
            //收件人地址
            message.setTo(phone);
            //邮件标题
            message.setSubject("菩提阁");
            //邮件内容
            message.setText("您的验证码为:  " + code + "  打死不要告诉别人!");
//            发送邮件
            mailSender.send(message);

            //将生成的验证码缓存到Redis中,并且设置有效期为5分钟
            redisTemplate.opsForValue().set(phone,code,5, TimeUnit.MINUTES);

            return R.success("发送邮件成功");
        }
        return R.error("发送邮件失败");
    }

    /**
     * 移动端用户登录
     *
     * @param map
     * @param session
     * @return
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session) {

        log.info(map.toString());
        //获取手机号
        String phone = map.get("phone").toString();
        //获取验证码
        String code = map.get("code").toString();

        //从redis中获取保存的验证码
        Object codeInSession = redisTemplate.opsForValue().get(phone);

        //获取存入session的验证码
//        Object codeInSession = session.getAttribute(phone);
        //进行验证码比对
        if (codeInSession != null && codeInSession.equals(code)) {
            //如果对比成功，说明登录成功
            //如果为新用户，就完成注册
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);

            User user = userService.getOne(queryWrapper);

            if (user == null) {
                //判断当前邮箱号对应的用户是否为新用户，如果新用户就必须完成注册
                user = new User();
                user.setPhone(phone);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());

            //如果用户登录成功，删除redis中缓存的验证码
            redisTemplate.delete(phone);


            return R.success(user);
        }
        return R.error("登录失败");
    }

}
