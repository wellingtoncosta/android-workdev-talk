package io.github.wellingtoncosta.androidworkdevtalk.app.contactregistration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.wellingtoncosta.androidworkdevtalk.domain.Contact
import io.github.wellingtoncosta.androidworkdevtalk.domain.ContactRepository

class ContactRegistrationViewModel(
    private val repository: ContactRepository
) : ViewModel() {

    private val _saving = MutableLiveData<Boolean>()

    val saving = _saving as LiveData<Boolean>

    fun save(contact: Contact) {
        _saving.value = true
        repository.insert(contact)
        _saving.value = false
    }

}