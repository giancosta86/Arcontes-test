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
import info.gianlucacosta.arcontes.algorithms.run.AlgorithmRunService;
import info.gianlucacosta.arcontes.algorithms.run.DefaultAlgorithmRunService;
import info.gianlucacosta.arcontes.graphs.GraphContext;
import org.junit.Before;

/**
 * Base test fixture for testing algorithms.
 * <p>
 * The create...() methods are called by the setUp() method, therefore before
 * the execution of every test method.
 */
public abstract class AlgorithmTest<TAlgorithm extends Algorithm> {

    private AlgorithmRunService algorithmRunService;

    private GraphContext graphContext;
    private AlgorithmSettings algorithmSettings;
    private AlgorithmInput algorithmInput;
    private AlgorithmOutput algorithmOutput;

    private TAlgorithm algorithm;

    @Before
    public void setUp() {
        algorithmRunService = new DefaultAlgorithmRunService();

        graphContext = createGraphContext();
        algorithmSettings = createAlgorithmSettings();
        algorithmInput = createAlgorithmInput();
        algorithmOutput = createAlgorithmOutput();

        algorithm = createAlgorithm();
    }

    protected abstract GraphContext createGraphContext();

    protected abstract AlgorithmSettings createAlgorithmSettings();

    /**
     * Creates the AlgorithmInput used by the algorithm.
     *
     * @return an instance of AlgorithmInput. A good choice might be an instance
     * of ScriptedAlgorithmInput
     */
    protected abstract AlgorithmInput createAlgorithmInput();

    protected abstract AlgorithmOutput createAlgorithmOutput();

    /**
     * Creates the algorithm. You can use most class getters, such as
     * getGraphContext(), within this method, in order to correctly construct
     * the algorithm.
     *
     * @return The algorithm instance
     */
    protected abstract TAlgorithm createAlgorithm();

    protected GraphContext getGraphContext() {
        return graphContext;
    }

    protected AlgorithmSettings getAlgorithmSettings() {
        return algorithmSettings;
    }

    protected AlgorithmInput getAlgorithmInput() {
        return algorithmInput;
    }

    protected AlgorithmOutput getAlgorithmOutput() {
        return algorithmOutput;
    }

    protected TAlgorithm getAlgorithm() {
        return algorithm;
    }

    /**
     * Starts the execution of the algorithm and runs all the steps until the
     * algorithm ends or throws an exception
     *
     * @throws AlgorithmException might be thrown by the algorithm
     */
    protected void fullRun() throws AlgorithmException {
        algorithmRunService.start(algorithm);
        algorithmRunService.runToEnd();
    }

    /**
     * Starts the execution of the algorithm and runs the specified number of
     * steps
     *
     * @param numberOfSteps the number of steps to run
     * @throws AlgorithmException might be thrown by the algorithm
     */
    protected void runSteps(int numberOfSteps) throws AlgorithmException {
        algorithmRunService.start(algorithm);

        for (int i = 1; i <= numberOfSteps; i++) {
            algorithmRunService.runStep();
        }
    }

}
