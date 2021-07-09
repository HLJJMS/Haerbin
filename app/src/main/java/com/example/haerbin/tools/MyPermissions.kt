package com.example.haerbin.tools

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.text.TextUtils
import androidx.fragment.app.FragmentActivity
import com.example.haerbin.BuildConfig
import com.tbruyelle.rxpermissions3.Permission
import com.tbruyelle.rxpermissions3.RxPermissions
import io.reactivex.rxjava3.functions.Consumer


class MyPermissions(context: FragmentActivity, resultListen: ResultListen) {
    var context: FragmentActivity?=null
    var resultListen:ResultListen?=null
    init {
        this.context = context
        this.resultListen = resultListen
    }
    fun getPermissions(vararg permissions: String) {
        context?.let {
            RxPermissions(it).requestEachCombined(*permissions)
                .subscribe(Consumer<Permission> { permission ->
                    if (permission.granted) {
                        // 用户已经同意该权限
                        this.resultListen?.allow()
                    } else if (permission.shouldShowRequestPermissionRationale) {
                        // 用户拒绝了该权限，没有选中『不再询问』（Never ask again）,那么下次再次启动时。还会提示请求权限的对话框
                        this.resultListen?.ban()
                    } else {
                        // 用户拒绝了该权限，而且选中『不再询问』那么下次启动时，就不会提示出来了，
                        goSetting(context!!)
                    }
                })
        }
    }


    interface ResultListen{
        fun allow ()
        fun ban()
    }

    fun goSetting(context: Context){
            val brand = Build.BRAND //手机厂商
            if (TextUtils.equals(brand.toLowerCase(), "redmi") || TextUtils.equals(
                    brand.toLowerCase(),
                    "xiaomi"
                )
            ) {
                gotoMiuiPermission(context) //小米
            } else if (TextUtils.equals(brand.toLowerCase(), "meizu")) {
                gotoMeizuPermission(context)
            } else if (TextUtils.equals(
                    brand.toLowerCase(),
                    "huawei"
                ) || TextUtils.equals(brand.toLowerCase(), "honor")
            ) {
                gotoHuaweiPermission(context)
            } else {
                context.startActivity(getAppDetailSettingIntent(context))
            }
    }




    /**
     * 跳转到miui的权限管理页面
     */
    private fun gotoMiuiPermission(context: Context) {
        try { // MIUI 8
            val localIntent = Intent("miui.intent.action.APP_PERM_EDITOR")
            localIntent.setClassName(
                "com.miui.securitycenter",
                "com.miui.permcenter.permissions.PermissionsEditorActivity"
            )
            localIntent.putExtra("extra_pkgname", context.getPackageName())
            context.startActivity(localIntent)
        } catch (e: Exception) {
            try { // MIUI 5/6/7
                val localIntent = Intent("miui.intent.action.APP_PERM_EDITOR")
                localIntent.setClassName(
                    "com.miui.securitycenter",
                    "com.miui.permcenter.permissions.AppPermissionsEditorActivity"
                )
                localIntent.putExtra("extra_pkgname", context.getPackageName())
                context.startActivity(localIntent)
            } catch (e1: Exception) { // 否则跳转到应用详情
                context.startActivity(getAppDetailSettingIntent(context))
            }
        }
    }

    /**
     * 跳转到魅族的权限管理系统
     */
    private fun gotoMeizuPermission(context: Context) {
        try {
            val intent = Intent("com.meizu.safe.security.SHOW_APPSEC")
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.putExtra("packageName", BuildConfig.APPLICATION_ID)
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            context.startActivity(getAppDetailSettingIntent(context))
        }
    }

    /**
     * 华为的权限管理页面
     */
    private fun gotoHuaweiPermission(context: Context) {
        try {
            val intent = Intent()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val comp = ComponentName(
                "com.huawei.systemmanager",
                "com.huawei.permissionmanager.ui.MainActivity"
            ) //华为权限管理
            intent.component = comp
            context.startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
            context.startActivity(getAppDetailSettingIntent(context))
        }
    }

    /**
     * 获取应用详情页面intent（如果找不到要跳转的界面，也可以先把用户引导到系统设置页面）
     */
    private fun getAppDetailSettingIntent(context: Context): Intent? {
        val localIntent = Intent()
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        localIntent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
        localIntent.data = Uri.fromParts("package", context.getPackageName(), null)
        return localIntent
    }
}