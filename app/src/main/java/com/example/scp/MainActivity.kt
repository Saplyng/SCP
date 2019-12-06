package com.example.scp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.unaryPlus
import androidx.ui.animation.Crossfade
import androidx.ui.core.Text
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.tooling.preview.Preview
import androidx.ui.core.*
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.DrawImage
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.Divider
import androidx.ui.material.surface.Surface
import androidx.ui.material.themeColor
import androidx.ui.material.themeTextStyle
import androidx.ui.res.imageResource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                TabWithTopics("SCP",songs)
            }
        }
    }
}

@Composable
private fun TabWithTopics(tabname: String, topics: List<String>){
    VerticalScroller{
        Column{
            HeightSpacer(16.dp)
            topics.forEach{ topic ->
                Clickable( onClick = {
                    navigateTo(Screen.Picture)
                }){TopicItem(
                        getTopicKey(
                                tabname,
                                "- ",
                                topic
                        ), topic
                )}

                TopicDivider()
            }
        }
    }
}

@Composable
private fun TopicItem(topicKey: String, itemTitle: String){
    val image = +imageResource(R.drawable.placeholder_1_1)
//    val image = MediaMetadataRetriever().primaryImage
    Padding(left = 16.dp, right = 16.dp) {
        FlexRow(
                crossAxisAlignment = CrossAxisAlignment.Center
        ){
            inflexible{
                Container(width = 56.dp, height = 56.dp){
                    Clip(
                            RoundedCornerShape(4.dp)){
                            DrawImage(image)
                    }
                }
            }
            expanded(1f){
                Text(
                        text = itemTitle,
                        modifier = Spacing(16.dp),
                        style = +themeTextStyle { subtitle1 }
                )
            }

        }
    }
}

@Composable
private fun TopicDivider(){
    Opacity(opacity = 0.08f) {
        Divider(Spacing(top = 8.dp, bottom = 8.dp, left = 72.dp))
    }
}
private fun getTopicKey(tab:String, group:String, topic:String)= "$tab=$group-$topic"

