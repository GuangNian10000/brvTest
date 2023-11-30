package com.brvTest.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.brvTest.myapplication.databinding.ItemChapterTableNameBinding
import com.drake.brv.utils.bindingAdapter
import com.drake.brv.utils.linear
import com.drake.brv.utils.setup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /**
         * bug步骤：
         * 1.点击text1高亮
         * 2.点击正反排序，列表变化
         * 3.点击text50：此时出现第一个bug->text1选中不了，然后选中text49
         * 3.再次点击正反排序：第二个bug->text1高亮并未取消，再次切换排序会发现list一共有2处高亮了，而我现在的时候是单选模式
         * 4.甚至还可以点击其他item会发现可以有三处高亮
         * 5.重复以上步骤可以一直选中
         * */

        val list = ArrayList<Test>()
        for (i in 1..50) {
            list.add(Test("text$i"))
        }

        findViewById<TextView>(R.id.tvS).setOnClickListener {
            list.reverse()
            findViewById<RecyclerView>(R.id.rv).bindingAdapter.notifyDataSetChanged()
        }

        findViewById<RecyclerView>(R.id.rv).linear().setup {
            singleMode = true
            addType<Test>(R.layout.item_chapter_table_name)
            onBind {
                when(itemViewType) {
                    R.layout.item_chapter_table_name -> {
                        getBinding<ItemChapterTableNameBinding>().apply {
                            getModelOrNull<Test>()?.let { data->
                            }}}
                }
            }

            onChecked { position, isChecked, isAllChecked ->
                val model = getModel<Test>(position)
                model.isChecked = isChecked
                model.notifyChange() // 通知UI跟随数据变化
            }

            R.id.item.onClick {
                getModelOrNull<Test>()?.let { data->
                    val isChecked = getModel<Test>().isChecked
                    setChecked(adapterPosition, !isChecked) // 在点击事件中触发选择事件, 即点击列表条目就选中
                    }
                }}.models = list
        }

}