package com.chat.bot.entity;

import java.io.Serializable;
import java.util.Arrays;

public class Request {
	private Result[] result;
	
	public final Result[] getResult() {
		return result;
	}

	public final void setResult(Result[] result) {
		this.result = result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Request [result=");
		builder.append(Arrays.toString(result));
		builder.append("]");
		return builder.toString();
	}

	public class Result implements Serializable {
		private static final long serialVersionUID = 1L;
		
		private String from;
		private String fromChannel;
		private String[] to;
		private String toChannel;
		private String eventType;
		private String id;
		
		public final String getFrom() {
			return from;
		}
		
		public final void setFrom(String from) {
			this.from = from;
		}
		
		public final String getFromChannel() {
			return fromChannel;
		}
		
		public final void setFromChannel(String fromChannel) {
			this.fromChannel = fromChannel;
		}
		
		public final String[] getTo() {
			return to;
		}
		
		public final void setTo(String[] to) {
			this.to = to;
		}
		
		public final String getToChannel() {
			return toChannel;
		}
		
		public final void setToChannel(String toChannel) {
			this.toChannel = toChannel;
		}
		
		public final String getEventType() {
			return eventType;
		}
		
		public final void setEventType(String eventType) {
			this.eventType = eventType;
		}
		
		public final String getId() {
			return id;
		}
		
		public final void setId(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Result [from=");
			builder.append(from);
			builder.append(", fromChannel=");
			builder.append(fromChannel);
			builder.append(", to=");
			builder.append(Arrays.toString(to));
			builder.append(", toChannel=");
			builder.append(toChannel);
			builder.append(", eventType=");
			builder.append(eventType);
			builder.append(", id=");
			builder.append(id);
			builder.append("]");
			return builder.toString();
		}
	}
}
