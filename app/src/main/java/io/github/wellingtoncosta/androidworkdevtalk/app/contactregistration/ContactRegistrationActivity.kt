package io.github.wellingtoncosta.androidworkdevtalk.app.contactregistration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import io.github.wellingtoncosta.androidworkdevtalk.R
import io.github.wellingtoncosta.androidworkdevtalk.domain.Contact
import io.github.wellingtoncosta.androidworkdevtalk.databinding.ActivityContactRegistrationBinding as Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContactRegistrationActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<Binding>(this, R.layout.activity_contact_registration)
    }

    private val viewModel by viewModel<ContactRegistrationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.contact = Contact(id = null, name = "", email = "", phone = "")

        setupToolbar()
        observeSaving()
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener { finish() }
    }

    private fun observeSaving() {
        viewModel.saving.observe(this, Observer {
            if(!it) finish()
        })
    }

}
