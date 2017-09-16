package cn.shuyuyin.ui.activity

import android.content.Intent
import android.support.v4.app.Fragment
import android.widget.RadioButton
import android.widget.RadioGroup
import cn.shuyuyin.R
import cn.shuyuyin.ui.base.BaseActivity
import cn.shuyuyin.ui.fragment.MeFragment
import cn.shuyuyin.ui.fragment.MessageFragment
import cn.shuyuyin.ui.fragment.WenziFragment
import cn.shuyuyin.ui.fragment.YanChangHuiFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    private var preFragment: Fragment? = null
    private var mPosition: Int = 0
    private var mFragments: ArrayList<Fragment> = ArrayList()
    private var currntPosition: Int = 0


    override fun setLayoutView(): Int {
        return R.layout.activity_main
    }

    override fun onResume() {
        super.onResume()
        changeRBState(currntPosition)

    }

    private fun changeRBState(currntPosition: Int) {

        when (currntPosition) {
            0 -> {
                rg_main.check(R.id.rb_wenzi)
            }
            1 -> {
                rg_main.check(R.id.rb_yanchanghui)
            }
            2 -> {
                rg_main.check(R.id.rb_message)
            }
            3 -> {
                rg_main.check(R.id.rb_me)
            }
        }

    }

    override fun init() {

        initFragment()

        rg_main.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(radioGroup: RadioGroup?, id: Int) {
                when (id) {
                    R.id.rb_wenzi -> {
                        mPosition = 0

                    }
                    R.id.rb_yanchanghui -> {
                        mPosition = 1
                    }
                    R.id.rb_center -> {
                        mPosition = 4
                        val radioButton = radioGroup!!.getChildAt(2) as RadioButton
                        radioButton.isChecked = false

                    }
                    R.id.rb_message -> {
                        mPosition = 2

                    }
                    R.id.rb_me -> {
                        mPosition = 3

                    }


                }

                when (mPosition) {
                    4 -> {
                        startActivity(Intent(this@MainActivity, HomeCenterActivity::class.java))
                    }

                    0, 1, 2, 3 -> {
                        currntPosition = mPosition
                        val fragment = mFragments.get(mPosition)
                        changeFragment(fragment)
                    }

                }


            }

        })

        rg_main.check(R.id.rb_wenzi)

    }

    private fun changeFragment(fragment: Fragment) {

        val ft = supportFragmentManager.beginTransaction()
        if (fragment != preFragment) {
            if (fragment.isAdded) {
                if (preFragment != null) {
                    ft.hide(preFragment)
                }
                ft.show(fragment)
            } else {
                if (preFragment != null) {
                    ft.hide(preFragment)
                }
                ft.add(R.id.fl_main, fragment)
            }
        }
        preFragment = fragment
        ft.commit()

    }

    private fun initFragment() {
        mFragments.add(WenziFragment())
        mFragments.add(YanChangHuiFragment())
//        mFragments.add(HomeCenterFragment())
        mFragments.add(MessageFragment())
        mFragments.add(MeFragment())

    }

}
