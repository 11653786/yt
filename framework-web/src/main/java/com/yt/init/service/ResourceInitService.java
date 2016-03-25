//package com.yt.init.service;
//
//import com.yt.model.BaseResult;
//import com.yt.util.yt.myutils.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.lang.reflect.Method;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created by Administrator on 2016/3/24 0024.
// */
//@Service
//public class ResourceInitService {
//
//
//    @Autowired(required = false)
//    private ISysResourceService sysResourceInvokeService;
//
//
//    @Autowired(required = false)
//    private IResourceGroupService resourceGroupInvokeService;
//
//
//    private List<Class<?>> needInitClass;
//
//
//    public void addClass(Class clazz) {
//        if (!StringUtils.checkNotNull(needInitClass)) {
//            this.needInitClass = Lists.newArrayList();
//        }
//        this.needInitClass.add(clazz);
//    }
//
//
//    public BaseResult registResource() {
//        BaseResult result = new BaseResult(true);
//        if (EmptyUtil.isNotEmpty(needInitClass) && needInitClass.size() > 0) {
//            for (Class clazz : needInitClass
//                    ) {
//                this.registResourceByClass(clazz);
//            }
//            this.needInitClass = null;
//        } else {
//            result.setMsg("系统已经初始化");
//            result.setSuccess(false);
//        }
//        return result;
//    }
//
//
//    public void registResourceByClass(Class<?> clazz) {
//        Method[] methods = clazz.getMethods();
//        ResourceAnnotation classRes = clazz.getAnnotation(ResourceAnnotation.class);
//
//        ResourceGroup group = this.resourceGroupInvokeService.findByName(classRes.resourceGroup());
//        if (EmptyUtil.isEmpty(group)) {
//            group = new ResourceGroup();
//            group.setGroupName(classRes.resourceGroup());
//            group.setId(this.resourceGroupInvokeService.save(group));
//        }
//        List<Method> needRetryMethods = registResource(Arrays.asList(methods), group);
//        if (EmptyUtil.isNotEmpty(needRetryMethods) && needRetryMethods.size() > 0) {
//            for (int i = 0; i < 5; i++) {
//                needRetryMethods = registResource(Arrays.asList(methods), group);
//            }
//        }
//    }
//
//
//    private List<Method> registResource(List<Method> methods, ResourceGroup group) {
//        List<Method> needRetryMethods = Lists.newArrayList();
//        for (Method method : methods) {
//            ResourceAnnotation resourceAnnotation = method.getAnnotation(ResourceAnnotation.class);
//            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
//            if (EmptyUtil.isNotEmpty(requestMapping) && EmptyUtil.isNotEmpty(resourceAnnotation)) {
//                //先判断是否存在了再做操作
//
//                SysResource extisResource = this.sysResourceInvokeService.findByName(resourceAnnotation.name());
//                if (EmptyUtil.isEmpty(extisResource)) {
//                    SysResource resource = new SysResource();
//                    resource.setUrl(resourceAnnotation.url());
//                    resource.setName(resourceAnnotation.name());
//                    resource.setTypeId(resourceAnnotation.resourceType());
//                    resource.setRemark(resourceAnnotation.remark());
//                    SysResource parentResource = this.sysResourceInvokeService.findByName(resourceAnnotation.pName());
//                    if (EmptyUtil.isEmpty(parentResource)) {
//                        if (resourceAnnotation.parentIsRoot()) {
//                            parentResource = new SysResource();
//                            parentResource.setName(resourceAnnotation.pName());
//                            parentResource.setRemark(resourceAnnotation.pName());
//                            parentResource.setTypeId(1);
//                            parentResource.setPid("root");
//                            parentResource.setTypeName("菜单");
//                            parentResource.setGroupName(group.getGroupName());
//                            parentResource.setGroupId(group.getId());
//                            parentResource.setId(this.sysResourceInvokeService.save(parentResource));
//                        } else {
//                            needRetryMethods.add(method);
//                            continue;
//                        }
//                    }
//
//                    resource.setGroupId(group.getId());
//                    resource.setGroupName(group.getGroupName());
//                    if (resourceAnnotation.resourceType() == 1) {
//                        resource.setTypeName("菜单");
//                    } else {
//                        resource.setTypeName("功能");
//                    }
//                    resource.setPid(parentResource.getId());
//                    resource.setPname(resourceAnnotation.pName());
//                    this.sysResourceInvokeService.save(resource);
//                }
//            }
//        }
//        return needRetryMethods;
//    }
//
//
//}
//
