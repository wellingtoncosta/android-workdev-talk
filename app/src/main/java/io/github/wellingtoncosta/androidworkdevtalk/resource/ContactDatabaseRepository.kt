package io.github.wellingtoncosta.androidworkdevtalk.resource

import io.github.wellingtoncosta.androidworkdevtalk.domain.Contact
import io.github.wellingtoncosta.androidworkdevtalk.domain.ContactRepository

class ContactDatabaseRepository : ContactRepository {

    private val contacts = ArrayList<Contact>()

    override fun findAll() = contacts

    override fun findById(contactId: Long) = contacts.firstOrNull { it.id == contactId }

    override fun insert(contact: Contact) { contacts.add(contact) }

    override fun update(contactId: Long, contact: Contact) {
        contacts.forEachIndexed { index, current ->
            if(current.id == contactId) {
                contacts[index] = contact
            }
        }
    }

    override fun delete(contactId: Long) {
        contacts.forEach {
            if(it.id == contactId) {
                contacts.remove(it)
            }
        }
    }
}