package com.yt.base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Administrator on 2016/3/24 0024.
 */
public class ResourceBaseController extends BaseAction implements InitializingBean {

    @Autowired
   // private ResourceInitService resourceInitService;

    @Value("${system.initResource}")
    private String initResource;

    /**
     * 处理resource资源信息
     */
    public void afterPropertiesSet() throws Exception {
        // resourceInitService.addClass(this.getClass());
        if("yes".equals(initResource)){
          //  resourceInitService.registResourceByClass(this.getClass());
        }

    }


}
