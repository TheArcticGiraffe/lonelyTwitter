/*
 * Copyright 2019 Seth Karstad
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING
 * BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */


package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Represents a Tweet
 *
 * @author Seth Karstad
 * @version 1.0
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */

public abstract class Tweet implements Tweetable {

    private Date date;
    private String message;
    private static final Integer MAX_CHARS = 140;

    //Empty argument constructor with default values
    /**
     * Constructs a Tweet object. Both date and message will be set to a default value.
     * @since 1.0
     */
    Tweet() {
        //Must use the 'this' keyword in order to specify the current object message = message does nothing!
        this.date = new Date();
        this.message = "I am default message schwa!";
    }

    //Overloading: so that we can specify the tweet content
    /**
     * Constructs a Tweet object, allowing a starting message to be specified. Date will be set to
     * a default value.
     * @param message String object representing the message to be set for the Tweet
     * @since 1.0
     */
    Tweet(String message) {
        this.date = new Date();
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    /**
     * Will set the message of the Tweet, overriding any message that may already be there.
     * May throw the TweetTooLongException, if the message that is passed is too long.
     * @param message String object representing the message to be set for the Tweet
     * @return void
     * @throws TweetTooLongException    This will be thrown if the message passed is greater than
     *                                  the max number of characters (this.MAX_CHARS).
     * @since 1.0
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() <= this.MAX_CHARS ) {
            this.message = message;
        } else {
            throw new TweetTooLongException();
        }
    }

    /**
     * Returns the date that the Tweet was entered.
     * @return this.date The Date object that is attached to the Tweet.
     * @since 1.0
     */
    public Date getDate() { return this.date; }

    //No method body implemented! We leave that up to the subclasses (they MUST implement it)
    public abstract Boolean isImportant();


    /**
     * Returns the message of the Tweet, as a String object.
     * @return message String object representing the message of the Tweet
     * @since 1.0
     */
    @Override
    public String toString(){
        return message;
    }

}