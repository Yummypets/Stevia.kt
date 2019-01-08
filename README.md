# Stevia.kt
[![Language: Kotlin](https://img.shields.io/badge/language-kotlin-7963FE.svg?style=flat)](https://kotlinlang.org)
![Platform: Android 8+](https://img.shields.io/badge/platform-Android-68b846.svg?style=flat)
[![codebeat badge](https://codebeat.co/badges/96edea1a-ed9d-4753-935b-a30d892e8b61)](https://codebeat.co/projects/github-com-yummypets-stevia-kt-master)
[![License: MIT](http://img.shields.io/badge/license-MIT-lightgrey.svg?style=flat)](https://github.com/Yummypets/Stevia.kt/blob/master/LICENSE)
<!-- TODO ![Release version](https://img.shields.io/github/release/Yummypets/Stevia.kt.svg) -->

With `Stevia.kt`, you build concise views in code using `ConstraintLayout`.

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

[Reason](#-reason) - [Installation](#️-installation) - [Documentation](#-documentation) - [Example](#login-view-example)

## 💡 Reason
Because **nothing holds more truth than pure code** 🤓  
XML files are **heavy, hard to maintain, hard to merge.**  
They split the view concept into 2 separate files making debugging a **nightmare**    
*There must be a better way*

### How
By creating a tool that makes layout code finally **readable by a human being**.   
View layout becomes **fun**, **concise**, **maintainable** and dare I say, *beautiful* ❤️


## ⚙️ Installation
Copy and paste the source folder for now :)

## 📖 Documentation
For reference you can also find the full iOS documentation [here](http://freshos.org/SteviaDocs/),
the concepts and naming are very similar.

### The 3 pillars of Layout: Hierarchy, Layout, Styling
Stevia chose the path of clearly separating the different layout steps.
It has a neat effect: you know exactly where to look for when coming back for modifying the code.  
Remember, code is read **way more often** than it is written!


#### 1 - View Hierarchy
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

#### 2 - Layout

##### Sizing
```kotlin
view.width(100)
view.height(50)
view.size(80)
```

##### Centering
```kotlin
view.centerHorizontally()
view.centerVertically(20) // offset
view.centerInParent()
```

##### Filling
```kotlin
view.fillHorizontally()
view.fillVertically(20) // padding
view.fillContainer()
```

#####  Positioning
```kotlin
view.top(100).left(30)
view.bottom(20).right(40)
```

These are all chainable :chain: :rocket:
```kotlin
view.size(60).top(80).centerHorizontally()
```

##### Horizontal layout
```kotlin

// Stick a label to the left of the screen
I-label

// With a custom margin
I-42-label

// Combine all at once \o/
I-avatar-15-name-20-followButton-I
```

##### Vertical Layout

```kotlin
layout(
    50,
    avatar
  )
// This is the equivalent of avatar.top(50)
```

While using `layout` for a single element might seem a bit overkill, it really **shines** when **combined with horizontal layout.**
Then we have the full **layout in one place** (hence the name).

```kotlin
layout(
    50,
    I-15-avatar.size(60)
  )
```
*The avatar is 50px from the top with a left margin of 15px and a size of 60px*

Another great example is a login view, representable in **one** single statement !

```kotlin
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

#### 3 - Styling

Well, just call `style` on a View subclass :

**In-line** for small or unique styles

```kotlin
textView.style {
    textSize = 4F.dp
    textAlignment = TEXT_ALIGNMENT_CENTER
}
```

Or in a separate function to make them reusable

```kotlin
// My style method, kinda like CSS
fun textStyle(t: TextView) {
    t.textSize = 4F.dp
    t.textAlignment = TEXT_ALIGNMENT_CENTER
}

// Later
{
  // Set my style
  textView.style(::textStyle)
}
```

This way the styles become **reusable** and **composable**: you can chain them!
You can even create a Style File grouping high level functions for common styles.
Usage then becomes very similar to CSS!

### Content & event binding.
There is no specific api for `Content` & `Event binding` so you just write it natively :)

### About dimensions
All Stevia margin and sizes use `dp` sizes to you don't have to explicitly specify it.

## 🖼 Example
Because an example is worth a thousand words :)
This is taken from a view we use in production.
Spoiler alert, write **Half the code** that is actually **10X more expressive and maintainable** 🤓

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
