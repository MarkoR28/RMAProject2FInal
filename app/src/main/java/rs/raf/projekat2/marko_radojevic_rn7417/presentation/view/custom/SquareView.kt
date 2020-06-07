package rs.raf.projekat2.marko_radojevic_rn7417.presentation.view.custom


import android.content.Context
import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.rn7417.marko_radojevic_rn7417.R


import timber.log.Timber

class SquareView : View {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private var rect: Rect = Rect()
    private var paint: Paint = Paint()
    private val redStrokePaint: Paint = Paint().also {
        it.isAntiAlias = true
        it.color = ContextCompat.getColor(context, R.color.red)
        it.style = Paint.Style.STROKE
        it.strokeWidth = 4.toPx().toFloat()
    }
    private val blueFillPaint: Paint = Paint().also {
        it.isAntiAlias = true
        it.color = ContextCompat.getColor(context, R.color.blue)
        it.style = Paint.Style.FILL
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        Timber.e("On measure")
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        Timber.e("On layout")
    }

    var val0 = 1
    var val1 = 2
    var val2 = 3
    var val3 = 4
    var val4 = 5

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        Timber.e("On draw" + val0 + "  "+ val1 + "  "+ val2 + "  "+ val3 + "  "+ val4)

        val left = 0
        val top = 0
        val bottom = height / 5 * val4
        val right = width / 5
        rect.set(left, top, right, bottom)
        canvas?.drawRect(rect, blueFillPaint)
        canvas?.drawRect(rect, redStrokePaint)

        val left2 = right
        val top2 = top
        val bottom2 = height / 5 * val3
        val right2 = 2* (width / 5)
        rect.set(left2, top2, right2, bottom2)
        canvas?.drawRect(rect, blueFillPaint)
        canvas?.drawRect(rect, redStrokePaint)

        val left3 = right2
        val top3 = top2
        val bottom3 = height / 5 * val2
        val right3 = 3* (width / 5)
        rect.set(left3, top3, right3, bottom3)
        canvas?.drawRect(rect, blueFillPaint)
        canvas?.drawRect(rect, redStrokePaint)

        val left4 = right3
        val top4 = top3
        val bottom4 = height / 5 * val1
        val right4 = 4* (width / 5)
        rect.set(left4, top4, right4, bottom4)
        canvas?.drawRect(rect, blueFillPaint)
        canvas?.drawRect(rect, redStrokePaint)

        val left5 = right4
        val top5 = top4
        val bottom5 = height / 5 * val0
        val right5 = 5* (width / 5)
        rect.set(left5, top5, right5, bottom5)
        canvas?.drawRect(rect, blueFillPaint)
        canvas?.drawRect(rect, redStrokePaint)



    }
    fun Int.toPx() : Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}