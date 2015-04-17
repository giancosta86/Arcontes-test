/*§
  ===========================================================================
  Arcontes - Test
  ===========================================================================
  Copyright (C) 2013-2015 Gianluca Costa
  ===========================================================================
  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
  ===========================================================================
*/

package info.gianlucacosta.arcontes.algorithms.test;

import info.gianlucacosta.arcontes.algorithms.*;

/**
 * Base test fixture for testing instances of CommonAlgorithm
 */
public abstract class CommonAlgorithmTest<TAlgorithm extends CommonAlgorithm> extends AlgorithmTest<TAlgorithm> {

    /**
     * You usually don't need to override this method
     *
     * @return an instance of DefaultCommonAlgorithmSettings
     */
    @Override
    protected CommonAlgorithmSettings createAlgorithmSettings() {
        DefaultCommonAlgorithmSettings result = new DefaultCommonAlgorithmSettings();

        return result;
    }

    /**
     * Provides a PrintStreamAlgorithmOutput associated with System.out
     *
     * @return the algorithm output instance
     */
    @Override
    protected AlgorithmOutput createAlgorithmOutput() {
        return new PrintStreamAlgorithmOutput();
    }

    @Override
    protected CommonAlgorithmSettings getAlgorithmSettings() {
        return (CommonAlgorithmSettings) super.getAlgorithmSettings();
    }
}
