package com.srisuk.carwashcustomer

import android.os.Bundle
import com.srisuk.carwashcustomer.base.BaseFragment
import com.srisuk.carwashcustomer.extension.setImageCircle
import com.srisuk.carwashcustomer.viewmodel.ProfileViewModel
import kotlinx.android.synthetic.main.fragment_profile.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment(R.layout.fragment_profile) {

     val viewModel by viewModel<ProfileViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.userinfo()

        viewModel.response.observe {
            tv_full_name.text = it.userInfo.fullName
            tv_phone.text = it.userInfo.phone
            iv_photo.setImageCircle(it.userInfo.image)
        }
    }
}
