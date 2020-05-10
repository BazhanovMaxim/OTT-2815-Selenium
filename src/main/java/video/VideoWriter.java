package video;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class VideoWriter {

    private static ScreenRecorder screenRecorder;

    public void startRecording(){
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        try {
            screenRecorder = new ScreenRecorder(gc,
                    gc.getBounds(),
                    new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                            QualityKey, 1.0f,
                            KeyFrameIntervalKey, 15 * 60),
                    new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black", FrameRateKey, Rational.valueOf(30)),
                    null,
                    new File("target/Videos"));
        } catch (IOException | AWTException e) {
            e.printStackTrace();
        }

        try {
            screenRecorder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String stopRecording(){
        List<File> path = screenRecorder.getCreatedMovieFiles();
        try {
            screenRecorder.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(File movie : path){
            return String.valueOf(movie);
        }
        return null;
    }

}
