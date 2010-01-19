using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.IO;
using System.Windows.Forms;

namespace LetterFonts {
  public partial class Form1 : Form {
    public Form1() {
      InitializeComponent();
    }

    //image set size
    Frame frame = new Frame();

    Bitmap image;
    Graphics graphics, show_graphics;
    FontDialog fontDialog = new FontDialog();


    public int image_width = 100;
    public int image_heigh = 100;

    public int text_x;
    public int text_y;

    //global variables

    private void button1_Click(object sender, EventArgs e) {
      if (fontDialog.ShowDialog() != DialogResult.Cancel) {
        textBox3.Font = fontDialog.Font;
      }
    }

    private void button2_Click(object sender, EventArgs e) {
      String text = textBox1.Text;
      String tmp;
      Bitmap show_image;

      int pos_x = (int)numericUpDown4.Value;
      int pos_y = (int)numericUpDown5.Value;
      int pos_z = (int)numericUpDown6.Value;
      int drill = (int)numericUpDown8.Value;
      int quant = (int)numericUpDown7.Value;
      int image_deep = (int)(numericUpDown3.Value);


      text_x = (int)numericUpDown9.Value;
      text_y = (int)numericUpDown10.Value;

      pictureBox1.Width = (int)(numericUpDown1.Value);
      image_width = (int)(numericUpDown1.Value);

      pictureBox1.Height = (int)(numericUpDown2.Value);
      image_heigh = (int)(numericUpDown2.Value);

      pos_z = pos_z + image_deep - drill;

      try {
        StreamWriter write = new StreamWriter(textBox2.Text);
        write.WriteLine("x\t y\t z");
        write.WriteLine("Density = " + quant);
        write.Close();


        image = new Bitmap(image_width, image_heigh);
        show_image = (Bitmap)image.Clone();

        graphics = Graphics.FromImage(image);
        graphics.FillRectangle(Brushes.White, 0, 0, image.Width, image.Height);

        show_graphics = Graphics.FromImage(show_image);
        show_graphics.FillRectangle(Brushes.White, 0, 0, show_image.Width, show_image.Height);

        fontDialog.Font = textBox3.Font;

        show_graphics.DrawString(textBox1.Text, fontDialog.Font, Brushes.Black, (float)text_x, (float)text_y);
        //graphics.DrawString(text.Substring(0, 2), fontDialog.Font, Brushes.Black, 0, 0);

        pictureBox1.Image = frame.cartesian_frame_show(show_image, quant, pos_x, pos_y, pos_z);


        for (int i = 1; i < text.Length + 1; i++) {
          tmp = text.Substring(i - 1, 1);
          if (tmp.CompareTo(" ") != 0) {
            write = File.AppendText(textBox2.Text);
            write.WriteLine("Letter = " + tmp);
            write.Close();
            System.Console.WriteLine("Letter = " + tmp);

            graphics.DrawString(text.Substring(0, i), fontDialog.Font, Brushes.Black, (float)text_x, (float)text_y);
            image = frame.convert_to_binary_image(image);
            frame.cartesian_frame_position(i, image, textBox2.Text, quant, pos_x, pos_y, pos_z);
          }
          else
            System.Console.WriteLine("Ignored a space");
        }
      }
      catch (Exception exp) {
        System.Console.WriteLine("Couldn't write to file.");
        System.Console.WriteLine("\t" + exp + "\n");
      }
    }
  }
}
