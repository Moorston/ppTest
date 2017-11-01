package com.mo.base.service.serviceImpl;

import com.mo.base.service.IVerifyCodeService;
import com.mo.base.utils.BidConst;
import com.mo.base.utils.DateUtil;
import com.mo.base.utils.UserContext;
import com.mo.base.vo.VerifyCodeVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Moonston on 2017/11/1.
 */
@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {

    @Value("${sms.username}")
    private String username;

    @Value("${sms.password}")
    private String password;

    @Value("${sms.apikey}")
    private String apiKey;

    @Value("${sms.url}")
    private String url;

    /**
     * 发送手机短信验证码
     * @param phoneNumber
     */
    @Override
    public void sendVeriyCode(String phoneNumber) {
        //判断当前用户是否已经发送短信
        //从session中获取到最后一次发送短信的时间
        VerifyCodeVO vc = UserContext.getCurrentVerifyCode();
        if (vc==null || DateUtil.secondsBetween(new Date(),vc.getLastSendTime())>90){
            //正常发送验证码
            //生成一个验证码
            String verifyCode = UUID.randomUUID().toString().substring(0,6);
            //发送短信

            try {
                //创建一个URL对象
                URL url = new URL(this.url);

                //通知URL的得到一个HTTPURLConnection连接对象
                HttpURLConnection connection =(HttpURLConnection) url.openConnection();

                //拼接POST请求的内容
                StringBuilder conn = new StringBuilder(100)
                        .append("username=").append(username)
                        .append("&password=").append(password)
                        .append("&apikey=").append(apiKey)
                        .append("&mobile=").append(phoneNumber)
                        .append("&content=").append("验证码是：")
                        .append(verifyCode).append(",请在5分钟内使用");
                //发送POST请求，POST或者GET一定大写
                connection.setRequestMethod("POSt");
                //设置POST请求是有请求体
                connection.setDoInput(true);
                //写入POST请求体
                connection.getOutputStream().write(conn.toString().getBytes());
                //得到响应流（其实已经发送过去了）
                String response = StreamUtils.copyToString(
                        connection.getInputStream(), Charset.forName("UTF-8"));
                if (response.startsWith("success:")){
                    //发送成功
                    // 把手机号码,验证码,发送时间装配到VO中并保存到session
                    vc = new VerifyCodeVO();
                    vc.setLastSendTime(new Date());
                    vc.setPhoneName(phoneNumber);
                    vc.setVerifyCode(verifyCode);
                    UserContext.putVerifyCode(vc);
                }else {
                    //发送失败
                    throw new RuntimeException();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("短信发送失败！");
            }
        }else {
            throw new RuntimeException("发送过于频繁！");
        }
    }

    @Override
    public boolean verify(String phoneNumber, String verifyCode) {
        VerifyCodeVO vc = UserContext.getCurrentVerifyCode();
        //发送了验证码
        if (vc!=null
                && vc.getPhoneName().equals(phoneNumber)
                && vc.getVerifyCode().equalsIgnoreCase(verifyCode)
                &&DateUtil.secondsBetween(new Date(),vc.getLastSendTime())<= BidConst.VERIFYCODE_VAILDATE_SECOND){
            return true;
        }
        return false;
    }
}
