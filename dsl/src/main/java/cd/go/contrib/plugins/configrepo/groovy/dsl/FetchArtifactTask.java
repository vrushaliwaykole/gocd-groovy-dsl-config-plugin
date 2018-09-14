/*
 * Copyright 2018 ThoughtWorks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cd.go.contrib.plugins.configrepo.groovy.dsl;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.stc.ClosureParams;
import groovy.transform.stc.SimpleType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

import static groovy.lang.Closure.DELEGATE_ONLY;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class FetchArtifactTask extends Task<FetchArtifactTask> {

    @Setter(AccessLevel.NONE)
    @Getter(AccessLevel.NONE)
    @Expose
    @SerializedName("is_source_a_file")
    private final Boolean isFile;

    @Expose
    @SerializedName("pipeline")
    @NotEmpty
    private String pipeline;

    @Expose
    @SerializedName("stage")
    @NotEmpty
    private String stage;

    @Expose
    @SerializedName("job")
    @NotEmpty
    private String job;

    @Expose
    @SerializedName("source")
    @NotEmpty
    private String source;

    @Expose
    @SerializedName("destination")
    @NotEmpty
    private String destination;

    public FetchArtifactTask() {
        this(false, null);
    }

    public FetchArtifactTask(Boolean isFile, @DelegatesTo(value = FetchArtifactTask.class, strategy = DELEGATE_ONLY) @ClosureParams(value = SimpleType.class, options = "cd.go.contrib.plugins.configrepo.groovy.dsl.FetchArtifactTask") Closure cl) {
        super("fetch");
        this.isFile = isFile;
        configure(cl);
    }

}
