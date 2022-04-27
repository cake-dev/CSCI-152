import java.awt.*;

public class KernelFilter {

    // Returns a new picture that applies the identity filter to the given picture.
    public static Picture identity(Picture picture) {
        int[][] identity_filter = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        return applyFilter(picture, identity_filter);
    }

    // Returns a new picture that applies a Gaussian blur filter to the given picture.
    public static Picture gaussian(Picture picture) {
        int[][] gaussian_filter = {{1, 2, 1}, {2, 4, 2}, {1, 2, 1}};
        return applyFilter(picture, gaussian_filter);
    }

    // Returns a new picture that applies a sharpen filter to the given picture.
    public static Picture sharpen(Picture picture) {
        int[][] sharpen_filter = {{0, -1, 0}, {-1, 5, -1}, {0, -1, 0}};
        return applyFilter(picture, sharpen_filter);
    }

    // Returns a new picture that applies an Laplacian filter to the given picture.
    public static Picture laplacian(Picture picture) {
        int[][] lap_filter = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};
        return applyFilter(picture, lap_filter);
    }

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int[][] emboss_filter = {{-2, -1, 0}, {-1, 1, 1}, {0, 1, 2}};
        return applyFilter(picture, emboss_filter);
    }

    // Returns a new picture that applies a motion blur filter to the given picture.
    public static Picture motionBlur(Picture picture) {
        int[][] motionblur_filter = {{1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 1}};
        return applyFilter(picture, motionblur_filter);
    }

    private static Picture applyFilter(Picture picture, int[][] k_filter) {
        double k_mod = 1;
        if (k_filter[1][1] == 4) {
            k_mod = 1.0 / 16.0;
        }
        if (k_filter[0].length > 3) {
            k_mod = 1.0 / 9.0;
        }
        Picture new_pic = new Picture(picture.width(), picture.height());
        int kern_length = k_filter[0].length;
        // half kernel size used for adjusting edge cases / iterating through filter
        int kern_half = kern_length / 2;
        Color[][] n_pixels = new Color[kern_length][kern_length];
        int p_width = picture.width();
        int p_height = picture.height();
        int ii;
        int jj;
        for (int row = 0; row < p_width; row++) {
            for (int col = 0; col < p_height; col++) {
                for (int i = row - kern_half, r = 0; i <= row + kern_half; i++, r++) {
                    if (r >= kern_length) r = 0;
                    for (int j = col - kern_half, c = 0; j <= col + kern_half; j++, c++) {
                        if (c >= kern_length) c = 0;
                        ii = i > p_width - kern_half ? 0 : i;
                        ii = i < 0 ? p_width - kern_half : ii;
                        jj = j > p_height - kern_half ? 0 : j;
                        jj = j < 0 ? p_height - kern_half : jj;
                        Color pixel = picture.get(ii, jj);
                        n_pixels[r][c] = pixel;
                    }
                }
                // FIXME somewhere here because of double / int conversions i am getting some off by 1 errors on color values
                int r_sum = 0;
                int g_sum = 0;
                int b_sum = 0;
                for (int i = 0; i < kern_length; i++) {
                    for (int j = 0; j < kern_length; j++) {
                        int red = (int) Math.round(n_pixels[i][j].getRed() * k_filter[i][j] * k_mod);
                        int green = (int) Math.round(n_pixels[i][j].getGreen() * k_filter[i][j] * k_mod);
                        int blue = (int) Math.round(n_pixels[i][j].getBlue() * k_filter[i][j] * k_mod);
                        r_sum += red;
                        g_sum += green;
                        b_sum += blue;
                    }
                }
                int red = Math.max(r_sum, 0);
                int green = Math.max(g_sum, 0);
                int blue = Math.max(b_sum, 0);
                if (red > 255) red = 255;
                if (green > 255) green = 255;
                if (blue > 255) blue = 255;
                Color new_pixel = new Color(red, green, blue);
                new_pic.set(row, col, new_pixel);
            }
        }
        return new_pic;
    }

    // Test client (ungraded).
    public static void main(String[] args) {
        Picture image = new Picture(args[0]);
        Picture filtered_pic = gaussian(image);
        filtered_pic.show();
    }

}
