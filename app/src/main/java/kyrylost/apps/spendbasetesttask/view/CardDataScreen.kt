package kyrylost.apps.spendbasetesttask.view

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kyrylost.apps.spendbasetesttask.adapters.ActivityAdapter
import kyrylost.apps.spendbasetesttask.databinding.CardDataScreenBinding
import kyrylost.apps.spendbasetesttask.model.ActivityItem
import kyrylost.apps.spendbasetesttask.model.ActivityItemList
import kyrylost.apps.spendbasetesttask.model.ActivityList

class CardDataScreen: Fragment() {
    private var _binding: CardDataScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CardDataScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = CardDataScreenArgs.fromBundle(requireArguments())

        val appLogoData = args.appLogoData
        val imageBytes = Base64.decode(appLogoData, Base64.DEFAULT)
        val image = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

        val details = args.details

        val lastDigits = args.lastDigits

        binding.categoryIcon.setImageBitmap(image)
        binding.details.text = details
        binding.cardNumberLastFour.text = "••" + lastDigits

        binding.card.post {
            val width = binding.card.width
            val params = binding.card.layoutParams
            params.height = (width / 1.5609).toInt()
            binding.card.layoutParams = params
        }

        val activityItemOne = ActivityItem(
            isPaymentAccepted = false,
            paymentReceiver = "Apple",
            isReceiptAdded = true,
            paymentAmount = "–$1,299"
        )

        val activityItemTwo = ActivityItem(
            isPaymentAccepted = true,
            paymentReceiver = "Uber",
            isReceiptAdded = false,
            paymentAmount = "–$37"
        )

        val activityItemThree = ActivityItem(
            isPaymentAccepted = true,
            paymentReceiver = "Hotels",
            isReceiptAdded = true,
            paymentAmount = "–$320"
        )

        val activityItemFour = ActivityItem(
            isPaymentAccepted = false,
            paymentReceiver = "Amazon",
            isReceiptAdded = true,
            paymentAmount = "–$1,299"
        )

        val activityItemFive = ActivityItem(
            isPaymentAccepted = true,
            paymentReceiver = "Google",
            isReceiptAdded = false,
            paymentAmount = "–$37"
        )

        val activityItemSix = ActivityItem(
            isPaymentAccepted = true,
            paymentReceiver = "Amazon",
            isReceiptAdded = true,
            paymentAmount = "–$1,299"
        )

        val activityItemSeven = ActivityItem(
            isPaymentAccepted = true,
            paymentReceiver = "Google",
            isReceiptAdded = false,
            paymentAmount = "–$37"
        )

        val activityList = ActivityList(
            listOf(
                Pair("Aug 27", ActivityItemList(listOf(activityItemOne, activityItemTwo, activityItemThree))),
                Pair("Aug 26", ActivityItemList(listOf(activityItemFour, activityItemFive, activityItemSix, activityItemSeven)))
            )
        )

        val adapter = ActivityAdapter(activityList, requireContext())
        binding.activityRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.activityRecyclerView.adapter = adapter

        binding.backBtn.setOnClickListener{
            val destination = CardDataScreenDirections.actionCardDataScreenToMainScreen(
                "", "", ""
            )
            findNavController().navigate(destination)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}