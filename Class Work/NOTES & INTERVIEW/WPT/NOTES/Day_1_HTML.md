# HTML:

## `<HEAD>` 
- Defines the head section of an HTML document.

## Two Types of Tags:
1. **Single tag**: 
   - Example: `<br>`
2. **Open-Close tag**: 
   - Example: `<p>...</p>` 

## Common Tags:
- **Paragraph**: 
  - `<p>...</p>`
- **Title**: 
  - `<title>...</title>` (Defines the title of the webpage, displayed in the browser tab)
- HTML is case insensitive.
- **DOCTYPE Declaration**: 
  - `<!DOCTYPE html>` used to specify the latest version of HTML.
- **Preformatted Text**: 
  - `<pre>...</pre>` (Preserves spaces and newlines entered in the content.)
- **Line Break**: 
  - `<br>` (Inserts a line break.)

## Anchor Tag:
- **Linking to other sites**: 
  - `<a href="site URL">click here</a>` (href stands for hyperlink reference).

## Alignment:
- By default, text is left-aligned.
- **Right Align**: 
  - `<p align="right">Right-aligned text</p>`
- **Justify Align**: 
  - `<p align="justify">Justified text</p>`

## Formatting Tags:
- **Bold**: 
  - `<b>Bold text</b>`
- **Italic**: 
  - `<i>Italic text</i>`

## Images:
- **Image Tag**: 
  - `<img src="image path/url" width="100" height="100">`
  - Tip: Place images in the same folder for easier referencing.

## Subscript & Superscript:
- **Subscript**: 
  - `H<sub>2</sub>O`
- **Superscript**: 
  - `x<sup>2</sup>`

## Comments:
- **HTML Comment**: 
  - `<!-- This is a comment -->`

## Lists:
1. **Ordered List**:
   - `<ol type="1">...</ol>` (Numeric by default)
     - Example: 
       ```html
       <ol>
         <li>Item 1</li>
         <li>Item 2</li>
       </ol>
       ```
   - Start from a specific number:
     - `<ol type="1" start="3">` (Starts from 3)
   - **Other Ordered Types**:
     - Capital letters: `<ol type="A">`
     - Small letters: `<ol type="a">`
     - Roman numerals: `<ol type="i">`
2. **Unordered List**:
   - `<ul type="circle">...</ul>` (Unordered list with circular bullets)

### List Items:
- **List Item**: 
  - `<li>Item name</li>`

## Tables:
- **Table Elements**:
  - `<th>`: Table header
  - `<tr>`: Table row
  - `<td>`: Table data
  - **Example**:
    ```html
    <table border="1">
      <tr>
        <td>Table data</td>
        <td>Table data</td>
        <td>Table data</td>
      </tr>
    </table>
    ```
- **Table Properties**:
  - `cellspacing`: Space between cells
  - `cellpadding`: Padding inside the cells

## Sections:
- **Divisions & Sections**:
  - `<div>...</div>`: Creates a section or container.
  - `<section>...</section>`: Semantic division of content.
  - `<nav>...</nav>`: Section for navigation links.
  - `<footer>...</footer>`: Section for footer content.

## Forms:
- **Form Elements**:
  - `<form action="url" method="GET">...</form>`
  - **Submit Button**: 
    - `<input type="submit" value="Submit">`
  - **Button**: 
    - `<input type="button" value="Click Me">`
- **Input Types**:
  - Text input: 
    - `<input type="text" placeholder="Enter name" maxlength="10">`
  - Password input: 
    - `<input type="password">`
  - Email input: 
    - `<input type="email" placeholder="Type Email">`
  - Number input: 
    - `<input type="number">`
  - Date input: 
    - `<input type="date">`

### Form Details:
- **Action**: 
  - Specifies the URL where the form data will be submitted.
- **Method**:
  - Defines how the data is sent (`GET` or `POST`).
  - Default method is `GET` if not specified.
