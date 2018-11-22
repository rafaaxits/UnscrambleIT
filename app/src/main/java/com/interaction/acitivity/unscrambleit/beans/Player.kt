package com.interaction.acitivity.unscrambleit.beans

import java.text.FieldPosition


class Player(var nome: String, var points: String, var position: Int) {
    override fun toString(): String {
        return "$nome ($points)"
    }
}