package com.brvTest.myapplication

import androidx.databinding.BaseObservable

/**
 * @author GuangNian
 * @description:
 * @date : 2023/11/30 10:33
 */
data class Test (val str :String= "" ,
                 var isChecked: Boolean = false,
                 var visibility: Boolean = false
) : BaseObservable()