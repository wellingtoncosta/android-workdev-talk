package io.github.wellingtoncosta.androidworkdevtalk.resource

import io.github.wellingtoncosta.androidworkdevtalk.domain.Contact
import io.github.wellingtoncosta.androidworkdevtalk.domain.ContactRepository

class ContactDatabaseRepository : ContactRepository {

    private val contacts = ArrayList<Contact>()

    init {
        contacts.addAll(listOf(
            Contact(1, "Lorrie Potts", "lorrie.potts@email.com", "+1 (848) 573-2104"),
            Contact(2, "Wade Nieves", "wade.nieves@email.com", "+1 (961) 527-2685"),
            Contact(3, "Barry Vang", "barry.vang@email.com", "+1 (991) 489-3025"),
            Contact(4, "Snider Allen", "snider.allen@email.com", "+1 (826) 574-2349"),
            Contact(5, "Silva Finley", "silva.finley@email.com", "+1 (887) 409-3362"),
            Contact(6, "Pierce Leonard", "pierce.leonard@email.com", "+1 (872) 459-2172"),
            Contact(7, "Eliza Davis", "eliza.davis@email.com", "+1 (845) 583-3489"),
            Contact(8, "Vicky Knapp", "vicky.knapp@email.com", "+1 (844) 475-3584"),
            Contact(9, "Nancy Hancock", "nancy.hancock@email.com", "+1 (869) 535-2431")
        ))
    }

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