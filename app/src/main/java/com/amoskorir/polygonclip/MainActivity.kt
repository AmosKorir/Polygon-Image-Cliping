package com.amoskorir.polygonclip

import android.graphics.*
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        createBitmap()
    }

    //    @RequiresApi(Build.VERSION_CODES.O)
    private fun createBitmap() {
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.gr)
        val mutableBitmap: Bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true)

        val bitmap2 = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888)
        val polyCanvas = Canvas(bitmap2)
        val canvas = Canvas(mutableBitmap)
//        canvas.drawColor(Color.LTGRAY)
        var paint = Paint()
        paint.strokeWidth = 9f
        paint.color = Color.RED
        val path = Path()
        path.moveTo(150f, 0f)
        path.lineTo(230f, 120f)
        path.lineTo(290f, 160f)
        path.lineTo(150f, 170f)
        path.lineTo(70f, 200f)
        path.lineTo(150f, 0f)
        polyCanvas.drawPath(path, paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        polyCanvas.drawBitmap(mutableBitmap, 0f, 0f, paint)

        imageView.setImageBitmap(bitmap2)

    }
}