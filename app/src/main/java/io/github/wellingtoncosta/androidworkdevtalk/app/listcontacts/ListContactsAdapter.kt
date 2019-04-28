package io.github.wellingtoncosta.androidworkdevtalk.app.listcontacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.wellingtoncosta.androidworkdevtalk.R
import io.github.wellingtoncosta.androidworkdevtalk.databinding.ListContactsItemBinding
import io.github.wellingtoncosta.androidworkdevtalk.domain.Contact

class ListContactsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val contacts = mutableListOf<Contact>()

    fun updateList(contacts: List<Contact>) {
        with(this.contacts) {
            clear()
            addAll(contacts)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListContactsViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_contacts_item, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = (holder as ListContactsViewHolder).binding
        val contact = contacts[position]
        binding.contact = contact
    }

    override fun getItemCount() = contacts.size

}

class ListContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding: ListContactsItemBinding = ListContactsItemBinding.bind(view)

}