using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Drawing;
using System.IO;
using System.Drawing.Imaging;

namespace LetterFonts
{
    class Frame
    {

        Bitmap prev_image;
        Bitmap temp_image;

        public Bitmap convert_to_binary_image(Bitmap src_image)
        {
            Color color;


            for (int x = 1; x < src_image.Height; x++)
            {
                for (int y = 0; y < src_image.Width; y++)
                {
                    color = src_image.GetPixel(y, x);

                    if ((color.R < 255) && (color.G < 255) && (color.B < 255))//not white 255 white
                    {
                        src_image.SetPixel(y, x, Color.Black);
                    }
                    else
                    {
                        src_image.SetPixel(y, x, Color.White);
                    }

                }
            }

            return src_image;
        }

        public Bitmap cartesian_frame_position(int im_n, Bitmap src_image, String filePath, int quant, int pos_x, int pos_y, int pos_z) // quant in mm
        {
            Color color;
            Color prev_color, im_color;
            int xx = 0;

            Color mark_color = Color.FromArgb(255, 255, 255);

            //StreamWriter write = new StreamWriter(filePath);
            

            //for images
            StreamWriter write = File.AppendText(filePath);
            if (im_n == 1)
            {
                //write.WriteLine("x\t y\t z");
                
                prev_image = (Bitmap)src_image.Clone();
            }

            // for appending bytes


            //StreamWriter write = File.AppendText(filePath);
            // sw.WriteLine("this is appended");
            // sw.Close();
             

            temp_image = (Bitmap)src_image.Clone();

            if (im_n > 1)
            {
                for (int x = 1; x < src_image.Height - 1; x++)
                {
                    for (int y = 1; y < src_image.Width - 1; y++)
                    {
                        prev_color   = prev_image.GetPixel(y, x);
                        im_color     = src_image.GetPixel(y, x);

                        if ((prev_color.R == im_color.R) && (prev_color.G == im_color.G) && (prev_color.B == im_color.B))
                        { 

                            src_image.SetPixel(y, x, mark_color);
                        }
                    }
                }
                prev_image = (Bitmap)temp_image.Clone();
            }

            //write.WriteLine("x\t y\t z");
            
            for (int x = src_image.Height - 1; x > -1; x--)
            {
                for (int y = 0; y < src_image.Width; y++)
                {
                    color = src_image.GetPixel(y, xx);
                    
                    if ((color.R < 255) && (color.G < 255) && (color.B < 255))//not white 255 white
                    {
                       // System.Console.WriteLine("" + (xx + pos_x) + "\t" + (y + pos_y) + "\t" + pos_z);
                        if((xx % quant == 0) && (y % quant == 0))
                        {
                            write.WriteLine("" + (xx + pos_x) + "\t" + (y + pos_y) + "\t" + pos_z);

                            System.Console.WriteLine("" + (xx + pos_x) + "\t" + (y + pos_y) + "\t" + pos_z);
                            src_image.SetPixel(y, xx, Color.Red);
                        }
                    }
                }
                xx++;
            }


            write.WriteLine("_____________NEXT_LETTER____________________");
            System.Console.WriteLine("_____________NEXT_LETTER____________________");

            write.Close();
            return src_image;
        }


        public Bitmap cartesian_frame_show(Bitmap src_image, int quant, int pos_x, int pos_y, int pos_z) // quant in mm
        {
            Color color;
            int xx = 0;

            for (int x = src_image.Height - 1; x > -1; x--)
            {
                for (int y = 0; y < src_image.Width; y++)
                {
                    color = src_image.GetPixel(y, xx);

                    if ((color.R < 255) && (color.G < 255) && (color.B < 255))//not white 255 white
                    {
                        if ((xx % quant == 0) && (y % quant == 0))
                        {
                            src_image.SetPixel(y, xx, Color.Red);
                        }
                    }
                }
                xx++;
            }
            return src_image;
        }















    }
    
}
