package app.takahashi.kamesan.originalapp

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner
import androidx.fragment.app.Fragment
import app.takahashi.kamesan.originalapp.databinding.FragmentSearchBinding


class SearchFragment : Fragment(app.takahashi.kamesan.originalapp.R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val player = arrayOf("1", "2", "3", "4", "5+")
    private val time = arrayOf("サクッと", "じっくり", "ガッツリ")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val playerAdapter =
            ArrayAdapter(this.requireContext(), R.layout.simple_spinner_item, player)
        playerAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        binding.playerNumber.adapter = playerAdapter

        val timeAdapter =
            ArrayAdapter(this.requireContext(), R.layout.simple_spinner_item, time)
        timeAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        binding.time.adapter = timeAdapter

        applyListener()

        //  検索ボタンが押された
        binding.searchButton.setOnClickListener {
            val intent = Intent(requireActivity(), SearchResultActivity::class.java)
            putData(intent)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun applyListener() {
        // プレイヤーのリスナーを登録
        binding.playerNumber.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            //　アイテムが選択された時
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
            }

            //　アイテムが選択されなかった
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        // 所要時間のリスナーを登録
        binding.time.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?, position: Int, id: Long
            ) {
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun putData(intent: Intent) {
        // プレイヤーの人数
        intent.putExtra("player", binding.playerNumber.selectedItemPosition)
        // 所要時間
        intent.putExtra("time", binding.time.selectedItemPosition)
        // ゲームの難易度
        intent.putExtra("easy", binding.checkboxEasy.isChecked)
        intent.putExtra("difficult", binding.checkboxDifficult.isChecked)
        // ゲームの種類
        intent.putExtra("playingcard", binding.playingcard.isChecked)
        intent.putExtra("boardgames",binding.boardgames.isChecked)
        intent.putExtra("online",binding.onlineGames.isChecked)
        // その他の条件
        val termsId = binding.radioGroup.checkedRadioButtonId
        val termsRadioButton = binding.radioGroup.findViewById<RadioButton>(termsId)
        val termsIndex = binding.radioGroup.indexOfChild(termsRadioButton)
        intent.putExtra("favorite", termsIndex)
    }

}