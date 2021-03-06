package com.lhy.xposed.mhzs.plugin;

import com.lhy.xposed.mhzs.helper.LogUtil;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;

/**
 * @author lhy
 */
@Deprecated
public class InfiniteCachePlugin implements IPlugin {

    private final String userInfoResponseClassName = "com.mh.movie.core.mvp.model.entity.response.UserInfoResponse";

    @Override
    public void run(ClassLoader classLoader) throws Throwable {
        XposedHelpers.findAndHookMethod(userInfoResponseClassName, classLoader, "getCanCacheNum", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                super.afterHookedMethod(param);
                LogUtil.e("Hook getRestCacheNum Method!");
                param.setResult(-1);
            }
        });
    }

    @Override
    public boolean isOpen() {
        return false;
    }
}
