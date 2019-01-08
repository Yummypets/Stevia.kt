# Stevia.kt
[![Language: Kotlin](https://img.shields.io/badge/language-kotlin-7963FE.svg?style=flat)](https://kotlinlang.org)
![Platform: Android 8+](https://img.shields.io/badge/platform-Android-68b846.svg?style=flat)
[![codebeat badge](https://codebeat.co/badges/96edea1a-ed9d-4753-935b-a30d892e8b61)](https://codebeat.co/projects/github-com-yummypets-stevia-kt-master)
[![License: MIT](http://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat)](https://github.com/Yummypets/Stevia.kt/blob/master/LICENSE)
<!-- TODO ![Release version](https://img.shields.io/github/release/Yummypets/Stevia.kt.svg) -->

`Stevia.kt` helps you build concise views in code making `ConstraintLayout` a breeze.

```kotlin
detail.top(35).left(12)
nameLabel.centerInParent()
backgroundImage.fillParent()
I-20-firstname-20-latname-20-I
```
This is all **native** `ConstraintLayout` under the hood 🎉

⚠️ Please be aware that this is an early version, the api is subject to change so use at your own risk :👨‍🔬👩‍🔬💥


This is a **kotlin** port of the popular [Stevia iOS](https://github.com/freshOS/Stevia) layout library. The new `ConstraintLayout` in android is very similar to the iOS AutoLayout so we figured, why not apply what we learnt on iOS to android?  
`Stevia.kt` was born 🚀  


## You + Stevia = 🦄
- [x] 💡 Write **concise**, **readable** layouts  
- [x] 🏖 **Reduce** your **maintenance** time  
- [x] 🎨 **Compose** your styles, **CSS-like**  

[Reason](#-reason) - [Example](#login-view-example) - [Installation](#️-installation) - [Documentation](#-documentation)

### 💡 Reason
Because **nothing holds more truth than pure code** 🤓  
XML files are **heavy, hard to maintain, hard to merge.**  
They split the view concept into 2 separate files making debugging a **nightmare**    
*There must be a better way*

#### How
By creating a tool that makes layout code finally **readable by a human being**.   
View layout becomes **fun**, **concise**, **maintainable** and dare I say, *beautiful* ❤️


### An example is worth a thousand words

This is taken from a view we use in production.
Spoiler alert, write **Half the code** that is actually **10X more expressive and maintainable** !

```kotlin
package com.octopepper.yummypets.component.food.home

import ...
import com.octopepper.yummypets.common.stevia.*

class FoodTypeFilter(context: Context, wording: String, imageResource: Int) : CardView(context) {

    var button = Button(context)
    private val constraintLayout = ConstraintLayout(context)
    private val imageView = ImageView(context)
    private val textView = TextView(context)

    init {

        // View Hierarchy
        subviews(
                constraintLayout.subviews(
                        imageView,
                        textView,
                        button
                )
        )

        // Layout
        constraintLayout.size(103)
        imageView.fillParent()
        textView.bottom(10).fillHorizontally()
        button.fillParent()

        // Style
        style {
            radius = 0F.dp
            cardElevation = 4F.dp
            useCompatPadding = true
            isClickable = true
            isFocusable = true
        }
        button.style {
            setBackgroundResource(selectableItemBackground(context))
            setBackgroundColor(Color.TRANSPARENT)
        }
        textView.style {
            textSize = 4F.dp
            textAlignment = TEXT_ALIGNMENT_CENTER
        }

        // Content
        imageView.setImageResource(imageResource)
        textView.text = wording
    }
}
```

### Why not anko?
Actually, coming from using Stevia extensively on iOS, first thing we did coming to android was looking for a similar approach: building views in code that don't suck.
Naturally we first tried anko which is very well known in the community.
After a while using it, I personally was still frustrated, yes the views were in code but I didn't
feel like the code was any clearer.

### Not clear
Indeed anko's classic approach is to do everything at once, View hierarchy, layout, styling.
While is seems tempting at first, the resulting code is compact and is quite hard to maintain.

### Not solving the layout part
Another issue I found was that although the view was written in code, nothing was actually improving the readability of the layout code itself.

### ⚙️ Installation
Copy and paste the source folder for now :)

### 📖 Documentation
For reference you can find the full iOS documentation [here](http://freshos.org/SteviaDocs/),
the concepts and naming are very similar.

### The Five pillars of Layout
Stevia chose the path of clearly separating the different layout steps.
It has a neat effect: you know exactly where to look for when coming back for modifying the code.  
Remember, code is read **way more often** than it is written!

- 1 View Hierarchy
- 2 Layout
- 3 Styling
- 4 Content
- 5 Event binding

#### 1 View Hierarchy
```kotlin
subviews(
  name,
  detail
)
```

`subviews()` is essentially a shortcut that calls `addView()` and
makes sure the view you are using has a unique id
setting `id = View.generateViewId()` on both subviews and the container itself.

It also has the benefit of being **very visual** so that your can actually **see** what the view hierarchy is.
This is especially true for nested hierarchies :

```kotlin
subviews(
    subview1,
    subview2.subviews(
        nestedView1,
        nestedView2̨
    ),
    subview3
)
```

Which is the equivalent of the native code below :

```kotlin
id = View.generateViewId()
subview1.id = View.generateViewId()
subview2.id = View.generateViewId()
subview3.id = View.generateViewId()
nestedView1.id = View.generateViewId()
nestedView2.id = View.generateViewId()
addView(subview1)
addView(subview2)
addView(subview3)
subview2.addView(nestedView1)
subview2.addView(nestedView2)
```


### About dimensions
All Stevia margin and sizes use `dp` sizes to you don't have to explicitly specify it.


### 🖼 Visual Layout Api
`layout` enables you to write both horizontal and vertical layout at the same time, making it very visual :)

```swift
layout(
    100,
    I-email-I,
    8,
    I-password-forgot-I,
    "",
    I-login-I,
    0
)
```
