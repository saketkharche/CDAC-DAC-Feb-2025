
# HTML (HyperText Markup Language)

HTML is the standard language used to create web pages. It defines the structure and layout of a web document using various tags and elements. HTML tags tell the browser how to display content on the webpage.

## Basic Structure of an HTML Document

Every HTML page follows a basic structure. Here’s how an HTML page is laid out:

```html
<!DOCTYPE html> <!-- Declaration to inform the browser about the version of HTML (HTML5) -->
<html>
  <head>
    <title>Page Title</title> <!-- Defines the title that appears on the browser tab -->
  </head>
  <body>
    <h1>This is a heading</h1> <!-- Main heading of the document -->
    <p>This is a paragraph.</p> <!-- Paragraph element -->
  </body>
</html>
```

## `<HEAD>` Element
The `<head>` element contains metadata about the HTML document like the title, links to CSS, JavaScript, etc.
Example:
```html
<head>
  <title>My Web Page</title> <!-- Defines the title shown on the browser tab -->
</head>
```

## Types of Tags in HTML

### Single Tag:
These tags stand alone and do not have a closing tag.
Example:
```html
<br> <!-- Inserts a line break -->
```

### Open-Close Tag:
These tags wrap around content and have both an opening and a closing tag.
Example:
```html
<p>This is a paragraph</p>
```

## Common HTML Tags and Their Uses:

### Paragraph Tag `<p>`
Defines a paragraph.
Example:
```html
<p>This is a paragraph of text.</p>
```

### Title Tag `<title>`
Defines the title of the webpage, which is shown on the browser’s tab or title bar.
Example:
```html
<title>My Web Page</title>
```

### HTML is Case-Insensitive
HTML tags can be written in either uppercase or lowercase without any difference in how they function.

### DOCTYPE Declaration `<!DOCTYPE html>`
Used to declare that we are using the latest version of HTML (HTML5).

### Preformatted Text Tag `<pre>`
Preserves the spaces, tabs, and line breaks in the content.
Example:
```html
<pre>
This text will
be displayed exactly
as written.
</pre>
```

### Line Break Tag `<br>`
Inserts a line break.
Example:
```html
This is line one.<br>This is line two.
```

### Anchor Tag `<a>`
Creates hyperlinks to other web pages.
The `href` attribute specifies the destination URL.
Example:
```html
<a href="https://www.example.com">Click here</a>
```

## Text Alignment
You can align paragraphs in different ways:

### Right Align:
```html
<p align="right">This text is aligned to the right.</p>
```

### Justified Align:
```html
<p align="justify">This paragraph is justified, making both sides even.</p>
```

## Text Formatting Tags

### Bold Text:
Example:
```html
<b>This text is bold.</b>
```

### Italic Text:
Example:
```html
<i>This text is italicized.</i>
```

## Images in HTML
To display an image, use the `<img>` tag. The `src` attribute specifies the image path, and `alt` provides alternative text in case the image is not found.
Example:
```html
<img src="image.jpg" alt="An Image" width="100" height="100">
```

## Subscript and Superscript
### Subscript (text below the baseline):
```html
H<sub>2</sub>O <!-- Outputs H₂O -->
```

### Superscript (text above the baseline):
```html
x<sup>2</sup> <!-- Outputs x² -->
```

## Comments in HTML
Comments are not displayed in the browser and are used for documentation within the HTML code.
Example:
```html
<!-- This is a comment -->
```

## Lists in HTML

### Ordered List: 
Displays items in a numbered format.
Example:
```html
<ol>
  <li>First Item</li>
  <li>Second Item</li>
  <li>Third Item</li>
</ol>
```

### Unordered List: 
Displays items in a bullet format.
Example:
```html
<ul>
  <li>First Item</li>
  <li>Second Item</li>
  <li>Third Item</li>
</ul>
```

## Tables in HTML
Tables are used to display data in a grid format.
Example:
```html
<table border="1"> <!-- Creates a table with a border -->
  <tr>
    <th>Header 1</th> <!-- Table header -->
    <th>Header 2</th>
  </tr>
  <tr>
    <td>Data 1</td> <!-- Table data -->
    <td>Data 2</td>
  </tr>
</table>
```

## Forms in HTML
Forms are used to take user input and submit data.
Example:
```html
<form action="submit.php" method="GET"> <!-- Specifies where to send the form data -->
  <input type="text" placeholder="Enter your name" maxlength="30"> <!-- Plain text input -->
  <input type="submit" value="Submit"> <!-- Submit button -->
</form>
```

