package com.qw.row.sample

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.qw.row.container.ContainerDescriptor
import com.qw.row.container.ContainerView
import com.qw.row.core.OnRowClickListener
import com.qw.row.core.Row
import com.qw.row.group.GroupDescriptor
import com.qw.row.item.*
import com.qw.row.utils.RowImageLoader

class MainActivity : AppCompatActivity(), OnRowClickListener {
    companion object {
        val id_friend = 1
        val id_scan = 2
        val id_shark = 3
        val id_look = 4
        val id_search = 5
        val id_nearby = 6
        val id_shop = 7
        val id_game = 8
        val id_mini = 9
        val id_open_close = 10
    }

    private lateinit var mContainerView: ContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RowImageLoader.init { url, imageView ->
            Glide.with(this@MainActivity).load(url).into(imageView)
        }
        mContainerView = findViewById(R.id.mContainerView)
        val groups = ArrayList<GroupDescriptor>()
        groups.add(
            GroupDescriptor().add(
                UserIconRowDescriptor.Builder()
                    .setLabel("头像")
                    .setAvatar("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1225597740,615370700&fm=111&gp=0.jpg")
                    .setId(id_friend).builder()
            )
        )
        groups.add(
            GroupDescriptor().add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("扫一扫")
                    .setId(id_scan).builder()
            ).add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("摇一摇")
                    .setId(id_shark)
                    .builder()
            )
        )
        groups.add(
            GroupDescriptor().add(
                SwitchRowDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("开关")
                    .setId(id_open_close)
                    .setChecked(true)
                    .builder()
            ).add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("搜一搜")
                    .setId(id_search)
                    .builder()
            )
        )
        groups.add(
            GroupDescriptor().add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("附近的人")
                    .setId(id_nearby)
                    .builder()
            )
        )
        groups.add(
            GroupDescriptor().add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("购物")
                    .setId(id_shop)
                    .builder()
            ).add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("游戏")
                    .setId(id_game)
                    .builder()
            )
        )
        groups.add(
            GroupDescriptor().add(
                GeneralDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("小程序")
                    .setId(id_mini)
                    .builder()
            ).add(
                IosDescriptor.Builder()
                    .setIcon(R.mipmap.ic_launcher)
                    .setLabel("手机号")
                    .setId(id_mini)
                    .setValue("17091314320")
                    .builder()
            ).add(
                IosDescriptor.Builder()
                    .setLabel("小程序")
                    .setId(id_mini)
                    .builder()
            )
        )
        val des = ContainerDescriptor(groups)
        mContainerView.initializeData(des, this)
        mContainerView.notifyDataChanged()
    }

    override fun onRowClick(rowView: Row) {
        when (rowView.rowId) {
            id_friend -> {
                Toast.makeText(this, "朋友圈", Toast.LENGTH_SHORT).show()
            }
            id_scan -> {
                Toast.makeText(this, "扫一扫", Toast.LENGTH_SHORT).show()
            }
            id_shark -> {
                Toast.makeText(this, "摇一摇", Toast.LENGTH_SHORT).show()
            }
            id_look -> {
                Toast.makeText(this, "看一看", Toast.LENGTH_SHORT).show()
            }
            id_search -> {
                Toast.makeText(this, "搜一搜", Toast.LENGTH_SHORT).show()
            }
            id_nearby -> {
                Toast.makeText(this, "附近的人", Toast.LENGTH_SHORT).show()
            }
            id_shop -> {
                Toast.makeText(this, "购物", Toast.LENGTH_SHORT).show()
            }
            id_game -> {
                Toast.makeText(this, "游戏", Toast.LENGTH_SHORT).show()
            }
            id_mini -> {
                Toast.makeText(this, "小程序", Toast.LENGTH_SHORT).show()
            }
            id_open_close -> {
                var switch = rowView as SwitchRowView
                Toast.makeText(this, "开关:" + switch.isChecked, Toast.LENGTH_SHORT).show()
            }
            else -> {
            }
        }
    }
}
