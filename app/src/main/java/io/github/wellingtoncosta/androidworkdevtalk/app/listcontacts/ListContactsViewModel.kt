package io.github.wellingtoncosta.androidworkdevtalk.app.listcontacts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.androidworkdevtalk.domain.Contact
import io.github.wellingtoncosta.androidworkdevtalk.domain.ContactRepository

class ListContactsViewModel(
    private val repository: ContactRepository
) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    private val _contacts = MutableLiveData<List<Contact>>()

    val loading = _loading as LiveData<Boolean>
    val contacts = _contacts as LiveData<List<Contact>>

    fun loadAll() {
        _loading.value = true
        _contacts.value = repository.findAll()
        _loading.value = false
    }

}