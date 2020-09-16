package video

import net.bramp.ffmpeg.builder.FFmpegBuilder
import net.bramp.ffmpeg.{FFmpeg, FFmpegExecutor, FFprobe}


object Video {

  def main(args: Array[String]): Unit = {
    mp4ToHLS()

        val process = Runtime.getRuntime.exec("cmd /c ffmpeg -i data/space.mp4 -filter:v \"hue=s=0\" data/graySpace5.mp4")

//    val process = Runtime.getRuntime.exec("cmd /c ffmpeg -i data/space.mp4 -c:v libx264 -c:a aac -strict -2 -f hls -hls_list_size 0 -hls_time 5 data/spaceOutput.m3u8")
//    ffmpeg -i hos.mp4 -strict -2 -acodec aac -vcodec libx264 -crf 25 hos_Phone.m3u8
    // -g 5 -hls_time 10

    //#EXTM3U
    //#EXT-X-VERSION:6
    //#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=2855600,CODECS="avc1.4d001f,mp4a.40.2",RESOLUTION=960x540
    //medium.m3u8
    //#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=5605600,CODECS="avc1.640028,mp4a.40.2",RESOLUTION=1280x720
    //high.m3u8
    //#EXT-X-STREAM-INF:PROGRAM-ID=1,BANDWIDTH=1755600,CODECS="avc1.42001f,mp4a.40.2",RESOLUTION=640x360
    //low.m3u8


//    val process = Runtime.getRuntime.exec("cmd /c dir")
//    val output = Source.fromInputStream(process.getInputStream).mkString
//    println(output)
  }


  def mp4ToHLS(): Unit ={

    val ffmpeg = new FFmpeg("ffmpeg");
    val ffprobe = new FFprobe("ffprobe");

    val builder = new FFmpegBuilder()
      .setInput("data/space.mp4")
      .addOutput("data/low/outputxxxxxx.m3u8")
      .setFormat("hls")
      .setAudioCodec("aac")
      .setVideoCodec("libx264")

      .setVideoResolution(128, 72)
      .done()

    val executor = new FFmpegExecutor(ffmpeg, ffprobe)

    executor.createJob(builder).run();

  }


  def example(): Unit ={
    //    ffmpeg -i hos.mp4 -strict -2 -acodec aac -vcodec libx264 -crf 25 hos_Phone.m3u8

    val ffmpeg = new FFmpeg("C:/Users/streamer/Downloads/ffmpeg/ffmpeg-4.2.2-win64-static/bin/ffmpeg");
    val ffprobe = new FFprobe("C:/Users/streamer/Downloads/ffmpeg/ffmpeg-4.2.2-win64-static/bin/ffprobe");

    val builder = new FFmpegBuilder().setInput("data/space.mp4")     // Filename, or a FFmpegProbeResult

      .overrideOutputFiles(true) // Override the output if it exists

      .addOutput("outputxxx.mp4")   // Filename for the destination
      .setFormat("mp4")        // Format is inferred from filename, or can be set
//      .setTargetSize(25000000)  // Aim for a 250KB file


//      .setAudioChannels(1)         // Mono audio
      .setAudioCodec("aac")        // using the aac codec
//      .setAudioSampleRate(48000)  // at 48KHz
//      .setAudioBitRate(32768)      // at 32 kbit/s

      .setVideoCodec("libx264")     // Video using x264
//      .setVideoFrameRate(24, 1)     // at 24 frames per second
//      .setVideoResolution(640, 480) // at 640x480 resolution

//      .setStrict(FFmpegBuilder.Strict.EXPERIMENTAL) // Allow FFmpeg to use experimental specs
      .done()

    val executor = new FFmpegExecutor(ffmpeg, ffprobe);

    // Run a one-pass encode
    executor.createJob(builder).run();

    // Or run a two-pass encode (which is better quality at the cost of being slower)
//    executor.createJob(builder).run();
  }

}
