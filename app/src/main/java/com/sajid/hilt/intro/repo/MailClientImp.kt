package com.sajid.hilt.intro.repo

import android.content.Context
import android.content.Intent
import android.net.Uri


class MailClientImp constructor(private val context: Context): MailClient {

    override fun sendMail() {
        Intent(Intent.ACTION_SENDTO).also {
            it.data = Uri.parse("mailto:")
            it.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(it)
        }
    }

}