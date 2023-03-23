package com.example.edna.ui.documentation

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.edna.R
import com.google.android.material.snackbar.Snackbar


class DocumentationFragment : Fragment(R.layout.fragment_documentation) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var emailTV = view.findViewById<TextView>(R.id.email_TV)

        //emailTV.text = "Email Our Team Lead At: princeri@oregonstate.edu"
        emailTV.setTextColor(Color.BLUE)

        view.findViewById<TextView>(R.id.email_TV).setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:princeri@oregonstate.edu")
            }
            try {
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Snackbar.make(view.findViewById(com.google.android.material.R.id.coordinator), "Cannot handle email. Please install an email app.",
                Snackbar.LENGTH_LONG).show()
            }

        }
    }
}