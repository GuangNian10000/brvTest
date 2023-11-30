package com.brvTest.myapplication

import android.app.Application
import com.drake.brv.utils.BRV

/**
 * GuangNian
 * 时间　: 2019/12/14
 * 描述　: 对于写BaseApp，其实我是拒绝的，但是需要提供一个很有用的功能--在Activity/fragment中获取Application级别的ViewModel
 * 所以才硬着头皮加的，如果你不想继承BaseApp，又想获取Application级别的ViewModel功能
 * 那么你可以复制该类的代码到你的自定义Application中去，然后可以自己写获取ViewModel的拓展函数即 :
 * GetViewModelExt类的getAppViewModel方法
 */

open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        BRV.modelId = BR.m
    }
}