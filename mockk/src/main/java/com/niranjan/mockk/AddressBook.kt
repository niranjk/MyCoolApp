package com.niranjan.mockk

interface AddressBook {
    val contacts: List<Contact>
}

interface Contact{
    val name: String
    val telephone: String
    val address: Address
}

interface Address {
    val city: String
    val zip: String
}