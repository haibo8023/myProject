package com.haibo.test.utils;

import com.github.pagehelper.util.StringUtil;
import com.haibo.test.constant.LianzhongDama;
import sun.misc.BASE64Decoder;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author XD
 * @date 2019/6/21 16:07
 */
public class Base64Util {
    /**
     * base64字符串转换成图片
     *
     * @param imgStr base64字符串
     * @return
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:42:17
     */
    public static String Base64ToImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
        String val = null;
// 图像数据为空
        if (StringUtil.isEmpty(imgStr)) {
            return val;
        }
        String fileName = "./img" + imgStr.length() + ".jpg";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                // 调整异常数据
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(fileName);
            out.write(b);
            out.flush();
            out.close();
            val = LianzhongDama.getCodeVal(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return val;
    }
}
