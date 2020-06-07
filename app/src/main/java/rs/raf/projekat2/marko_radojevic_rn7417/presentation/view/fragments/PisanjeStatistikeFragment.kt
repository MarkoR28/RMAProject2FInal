package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rn7417.marko_radojevic_rn7417.R

import kotlinx.android.synthetic.main.fragment_pisanje_statistike.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.contracts.BeleskaContract
import rs.raf.projekat2.marko_radojevic_rn7417.presentation.viewModel.BeleskeViewModel
import timber.log.Timber
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


class PisanjeStatistikeFragment : Fragment(R.layout.fragment_pisanje_statistike)  {


    private val beleskeViewModel : BeleskaContract.ViewModel by viewModel<BeleskeViewModel>()
    private val beleskeViewModel1 by viewModel<BeleskeViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {

        initUI()
    }

    private fun initUI() {
        applyBarHeightBtn.setOnClickListener {
            val cal = Calendar.getInstance()
            cal.clear(Calendar.HOUR_OF_DAY)
            cal.clear(Calendar.AM_PM)
            cal.clear(Calendar.MINUTE)
            cal.clear(Calendar.SECOND)
            cal.clear(Calendar.MILLISECOND)

            beleskeViewModel.getByDate(cal.time)

            beleskeViewModel1.statistikaList.forEach {
                Timber.e( ""+it.dateOfCreate )
            }
            val day0 = cal.time
            cal.add(Calendar.DAY_OF_YEAR, 1)
            val day1 = cal.time
            cal.add(Calendar.DAY_OF_YEAR, 1)
            val day2 = cal.time
            cal.add(Calendar.DAY_OF_YEAR, 1)
            val day3 = cal.time
            cal.add(Calendar.DAY_OF_YEAR, 1)
            val day4 = cal.time


            var size0 = beleskeViewModel1.statistikaList.filter { it.dateOfCreate==day0 }.size
            var size1 = beleskeViewModel1.statistikaList.filter { it.dateOfCreate==day1 }.size
            var size2 = beleskeViewModel1.statistikaList.filter { it.dateOfCreate==day2 }.size
            var size3 = beleskeViewModel1.statistikaList.filter { it.dateOfCreate==day3 }.size
            var size4 = beleskeViewModel1.statistikaList.filter { it.dateOfCreate==day4 }.size

            if(size0==0) { size0=1 }
            if(size1==0) { size1=1 }
            if(size2==0) { size2=1 }
            if(size3==0) { size3=1 }
            if(size4==0) { size4=1 }

            Timber.e("%s  %s  %s  %s  %s" ,size0,size1,size2,size3,size4)
            squareView.val0 = size0
            squareView.val1 = size1
            squareView.val2 = size2
            squareView.val3 = size3
            squareView.val4 = size4

            squareView.invalidate()
            beleskeViewModel1.statistikaList.clear()

        }
    }

    /*
       fun convertToDateViaInstant(dateToConvert: LocalDate):Date {
           return Date.from(dateToConvert.atStartOfDay(ZoneId.systemDefault()).toInstant())
       }*/

}
