package com.awesometickets.config;

import com.awesometickets.business.services.SmsService;
import com.awesometickets.web.controller.response.ErrorStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;


/**
 * bean构造器（Listener for beans construction）.
 */
@Component
public class BeanFinishedListener implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger LOG = LoggerFactory.getLogger(BeanFinishedListener.class);
    private static final String FILE_CONF = new File("").getAbsolutePath() + "/.sms-movieticket";
    private String[] configs = new String[2];

    /**
     * Called when all beans are constructed.
     */
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            LOG.info("Beans 已构造.");
            loadConfig();
            ErrorStatus.init();
            //如果使用maven启动项目，则需取消此行注释
            //SmsService.getInstance().init(configs[0], configs[1]);
            //LOG.info("sms ID:"+configs[0]+",sms key:"+configs[1]);
        }
    }

    /**
     * Load configurations from file.
     */
    private void loadConfig() {
        try {
            Resource resource = new FileSystemResource(FILE_CONF);
            InputStream inStream = resource.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String confStr = new String(outSteam.toByteArray());
            configs = confStr.split(",");
            LOG.warn("sms配置文件已加载.");
            LOG.warn("sms配置文件路径："+FILE_CONF);
        } catch (FileNotFoundException e) {
            LOG.warn("sms配置文件路径："+FILE_CONF);
            LOG.warn("sms配置文件未找到.");
            LOG.warn("使用默认id和key");
            SmsService.getInstance().init("y5IV5xeQExj4rE0pkTv6X2Ce-gzGzoHsz","R1mSnSRf47kxEJuau8OPjeiX");
        } catch (IOException e) {
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
