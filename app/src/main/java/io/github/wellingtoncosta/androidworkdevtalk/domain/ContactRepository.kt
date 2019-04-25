package io.github.wellingtoncosta.androidworkdevtalk.domain

interface ContactRepository {

    fun findAll(): List<Contact>

    fun findById(contactId: Long): Contact?

    fun insert(contact: Contact)

    fun update(contactId: Long, contact: Contact)

    fun delete(contactId: Long)

}