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


/**
 * This extends the Tweet class, allowing for NormalTweet objects.
 *
 * @author Seth Karstad
 * @see Tweet
 * @version 1.0
 *
 */
public class NormalTweet extends Tweet {

    /**
     * Constructs an instance of a NormalTweet, using the constructor for Tweet
     * @author
     * @see Tweet
     * @since 1.0
     */
    NormalTweet() {
        super();
    }


    /**
     * Constructs an instance of a NormalTweet, using the constructor for Tweet. The message passed
     * in will be included in the Tweet.
     * @author Seth Karstad
     * @param message String object representing the message to be tweeted
     * @see Tweet
     * @since 1.0
     */
    NormalTweet(String message) {
        super(message);
    }

    /**
     * Returns the boolean value true, indicating this is not an important tweet.
     * @author Seth Karstad
     * @return false
     * @see Tweet
     * @see ImportantTweet
     * @since 1.0
     */
    @Override
    public Boolean isImportant() {
        return false;
    }
}