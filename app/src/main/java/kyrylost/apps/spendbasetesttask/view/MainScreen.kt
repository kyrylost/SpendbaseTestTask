package kyrylost.apps.spendbasetesttask.view

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kyrylost.apps.spendbasetesttask.OnItemClickListener
import kyrylost.apps.spendbasetesttask.R
import kyrylost.apps.spendbasetesttask.adapters.CardAdapter
import kyrylost.apps.spendbasetesttask.adapters.TransactionAdapter
import kyrylost.apps.spendbasetesttask.addOnItemClickListener
import kyrylost.apps.spendbasetesttask.databinding.MainScreenBinding
import kyrylost.apps.spendbasetesttask.model.Card
import kyrylost.apps.spendbasetesttask.model.CardsList
import kyrylost.apps.spendbasetesttask.model.Transaction
import kyrylost.apps.spendbasetesttask.model.TransactionList
import java.io.ByteArrayOutputStream

class MainScreen: Fragment() {
    private var _binding: MainScreenBinding? = null
    private val binding get() =_binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val slackCard = Card(
            appLogoData = ContextCompat.getDrawable(requireContext(), R.drawable.slack)?.toBitmap()!!,
            details = "Slack",
            lastFourDigits = "7544"
        )
        val googleCard = Card(
            appLogoData = ContextCompat.getDrawable(requireContext(), R.drawable.google)?.toBitmap()!!,
            details = "Google",
            lastFourDigits = "2911"
        )
        val notionCard = Card(
            appLogoData = ContextCompat.getDrawable(requireContext(), R.drawable.notion)?.toBitmap()!!,
            details = "Notion",
            lastFourDigits = "2233"
        )

        val cardsList = CardsList(
            listOf(
                slackCard,
                googleCard,
                notionCard
            ).takeLast(3)
        )

        val adapter = CardAdapter(cardsList = cardsList)
        binding.myCardsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.myCardsRecyclerView.adapter = adapter
        binding.myCardsRecyclerView.addOnItemClickListener(object: OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                val baos = ByteArrayOutputStream()
                cardsList.get(position).appLogoData.compress(
                    Bitmap.CompressFormat.PNG, 100, baos
                )
                val b = baos.toByteArray()

                val destination = MainScreenDirections.actionMainScreenToCardDataScreen(
                    Base64.encodeToString(b, Base64.DEFAULT),
                    cardsList.get(position).details,
                    cardsList.get(position).lastFourDigits
                )

                findNavController().navigate(destination)
            }
        })

        val firstTransaction = Transaction(
            appLogoData = ContextCompat.getDrawable(requireContext(), R.drawable.slack)?.toBitmap()!!,
            details = "Slack",
            lastFourDigits = "7544",
            transactionCurrency = "–$29.47",
            isReceiptAdded = true
        )

        val secondTransaction = Transaction(
            appLogoData = ContextCompat.getDrawable(requireContext(), R.drawable.arrow_down)?.toBitmap()!!,
            details = "Slack",
            lastFourDigits = "7544",
            transactionCurrency = "$1000",
            isReceiptAdded = true
        )

        val thirdTransaction = Transaction(
            appLogoData = ContextCompat.getDrawable(requireContext(), R.drawable.google)?.toBitmap()!!,
            details = "Google",
            lastFourDigits = "2911",
            transactionCurrency = "–$399",
            isReceiptAdded = true
        )

        val transactionList = TransactionList(
            listOf(
                firstTransaction,
                secondTransaction,
                thirdTransaction
            ).takeLast(3)
        )

        val adapterT = TransactionAdapter(transactionList = transactionList)
        binding.recentTransactionsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recentTransactionsRecyclerView.adapter = adapterT

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}