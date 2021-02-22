package com.backbay2.shop.controller.front;

import com.backbay2.shop.util.verificate.Verificate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * Created by 蒋松冬 on 2017/7/22.
 */
@Controller
public class VerificationCodeImgController {
    //    @RequestMapping("/verificationcodeimg")
//    public ModelAndView verificationcodeimg(HttpServletResponse response, HttpSession session) throws IOException {
//        ModelAndView verificationcodeimg = new ModelAndView();
//        Verificate verificate = new Verificate();
//        String code = verificate.getCertPic(70, 25, response.getOutputStream());
//        session.setAttribute("certCode",code);
//
//        verificationcodeimg.setViewName("verificationcodeimg");
//        return verificationcodeimg;
//    }
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取验证码
     *
     * @param response
     * @param session
     */
    @RequestMapping("/verificationcodeimg")
    public void verificationcodeimg(HttpServletResponse response, HttpSession session) {
        drawImg(response, session);
    }

    /**
     * 绘画验证码
     *
     * @param response session
     * @return
     */
    private void drawImg(HttpServletResponse response, HttpSession session) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = "";
        // 随机产生4个字符
        for (int i = 0; i < 4; i++) {
            code += randomChar();
        }
        logger.debug(code);
        session.setAttribute("certCode", code);
        int width = 70;
        int height = 25;
        BufferedImage bi = new BufferedImage(width, height,
                BufferedImage.TYPE_3BYTE_BGR);
        Font font = new Font("Times New Roman", Font.PLAIN, 20);
        // 调用Graphics2D绘画验证码
        Graphics2D g = bi.createGraphics();
        g.setFont(font);
        Color color = new Color(66, 2, 82);
        g.setColor(color);
        g.setBackground(new Color(226, 226, 240));
        g.clearRect(0, 0, width, height);
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int) x, (int) baseY);
        g.dispose();
        try {
            //ImageIO.write(bi, "jpg", output);
            ImageIO.write(bi, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机参数一个字符
     *
     * @return
     */
    private char randomChar() {
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }

}
