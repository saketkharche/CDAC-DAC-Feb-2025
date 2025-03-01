import os
import subprocess

def convert_md_to_pdf(md_file, output_pdf):
    """
    Converts an Obsidian Markdown (.md) file to a properly formatted PDF, including images.
    Requires `pandoc` and `wkhtmltopdf` to be installed.
    
    :param md_file: Path to the input Markdown file.
    :param output_pdf: Path to the output PDF file.
    """
    if not os.path.exists(md_file):
        print("Error: Markdown file does not exist.")
        return
    
    # Define Pandoc command to convert Markdown to PDF
    pandoc_cmd = [
        "pandoc", md_file, "-o", output_pdf,
        "--from=markdown", "--to=pdf",
        "--pdf-engine=wkhtmltopdf",  # Ensures images are rendered correctly
        "--metadata", "title=Converted Document",
        "--variable", "geometry:margin=1in"  # Sets 1-inch margins for better formatting
    ]
    
    try:
        subprocess.run(pandoc_cmd, check=True)
        print(f"Successfully converted '{md_file}' to '{output_pdf}'")
    except subprocess.CalledProcessError as e:
        print(f"Error during conversion: {e}")

# Example usage
md_file_path = r"C:\Users\saket\OneDrive\Desktop\EveryThing\CDAC DAC study\CDAC-DAC-Feb-2025\Operating System\Assignment 2\Assignment2.md"  # Replace with your Markdown file path
output_pdf_path = "output.pdf"
convert_md_to_pdf(md_file_path, output_pdf_path)
