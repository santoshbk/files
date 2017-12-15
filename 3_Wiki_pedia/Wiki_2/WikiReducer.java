package com.WikiDataMining;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WikiReducer extends
		Reducer<Text, LongWritable, Text, IntWritable> {

	public void reduce(Text key, Iterable<LongWritable> value, Context output)
			throws IOException, InterruptedException {
		int sum = 0;
		for (LongWritable val : value) {
			sum += val.get();
		}
		output.write(key, new IntWritable(sum));
	}

}
