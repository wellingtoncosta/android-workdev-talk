package io.github.wellingtoncosta.androidworkdevtalk.app.listcontacts

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.wellingtoncosta.androidworkdevtalk.R
import io.github.wellingtoncosta.androidworkdevtalk.app.contactregistration.ContactRegistrationActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import io.github.wellingtoncosta.androidworkdevtalk.databinding.ActivityListContactsBinding as Binding

class ListContactsActivity : Handlers, AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<Binding>(this, R.layout.activity_list_contacts)
    }

    private val viewModel by viewModel<ListContactsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.handlers = this

        setupRecyclerView()
        observeContacts()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadAll()
    }

    private fun setupRecyclerView() {
        val dividerItemDecoration = DividerItemDecoration(
            binding.recyclerView.context,
            (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
        )

        binding.recyclerView.apply {
            addItemDecoration(dividerItemDecoration)
            adapter = ListContactsAdapter()
        }
    }

    private fun observeContacts() {
        viewModel.contacts.observe(this, Observer {
            (binding.recyclerView.adapter as ListContactsAdapter).updateList(it)
        })
    }

    override fun goToContactRegistrationScreen() {
        startActivity(Intent(this, ContactRegistrationActivity::class.java))
    }

}

internal interface Handlers {

    fun goToContactRegistrationScreen()

}
