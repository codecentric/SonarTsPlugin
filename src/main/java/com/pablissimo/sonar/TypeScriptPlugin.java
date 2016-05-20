package com.pablissimo.sonar;

import java.util.Arrays;
import java.util.List;

import org.sonar.api.Properties;
import org.sonar.api.Property;
import org.sonar.api.PropertyType;
import org.sonar.api.SonarPlugin;

import com.pablissimo.sonar.lcov.ITCoverageSensor;
import com.pablissimo.sonar.lcov.LOCSensor;
import com.pablissimo.sonar.lcov.OverallCoverageSensor;
import com.pablissimo.sonar.lcov.UTCoverageSensor;

@Properties({
  @Property(
    key = TypeScriptPlugin.SETTING_TS_LINT_PATH,
    defaultValue = "",
    name = "Path to TSLint",
    description = "Path to installed Node TSLint",
    project = false,
    global = true
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_EXCLUDE_TYPE_DEFINITION_FILES,
    type = PropertyType.BOOLEAN,
    defaultValue = "true",
    name = "Exclude .d.ts files",
    description = "Exclude .d.ts files from analysis",
    project = true,
    global = false
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_LCOV_UT_REPORT_PATH,
    type = PropertyType.STRING,
    name = "LCOV unit test report path",
    description = "LCOV unit test report path",
    project = true,
    global = false
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_LCOV_IT_REPORT_PATH,
    type = PropertyType.STRING,
    name = "LCOV integration test report path",
    description = "LCOV integration test report path",
    project = true,
    global = false
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_FORCE_ZERO_COVERAGE,
    defaultValue = "false",
    type = PropertyType.BOOLEAN,
    name = "Force 0 coverage",
    description = "Force coverage to be set to 0 when no report is provided.",
    project = true,
    global = false
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_TS_LINT_CONFIG_PATH,
    defaultValue = "tslint.json",
    type = PropertyType.STRING,
    name = "Path to tslint.json rule configuration file",
    description = "Path to the file that configures the rules to be included in analysis",
    project = true,
    global = false
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_TS_LINT_RULES_DIR,
    defaultValue = "",
    type = PropertyType.STRING,
    name = "Custom rules dir",
    description = "Path to any custom rules directory to be supplied to TsLint",
    project = true,
    global = false
  ),
  @Property(
    key = TypeScriptPlugin.SETTING_TS_LINT_TIMEOUT,
    defaultValue = "60000",
    type = PropertyType.INTEGER,
    name = "Max TsLint wait time (milliseconds)",
    description = "Maximum time to wait for TsLint execution to finish before aborting (in milliseconds)",
    project = true,
    global = false
  )
})
public class TypeScriptPlugin extends SonarPlugin {
  public static final String SETTING_EXCLUDE_TYPE_DEFINITION_FILES = "sonar.ts.excludetypedefinitionfiles";
  public static final String SETTING_FORCE_ZERO_COVERAGE = "sonar.ts.forceZeroCoverage";
  public static final String SETTING_TS_LINT_PATH = "sonar.ts.tslintpath";
  public static final String SETTING_TS_LINT_CONFIG_PATH = "sonar.ts.tslintconfigpath";
  public static final String SETTING_TS_LINT_TIMEOUT = "sonar.ts.tslinttimeout";
  public static final String SETTING_TS_LINT_RULES_DIR = "sonar.ts.tslintrulesdir";
  public static final String SETTING_LCOV_UT_REPORT_PATH = "sonar.ts.lcov.ut.reportpath";
  public static final String SETTING_LCOV_IT_REPORT_PATH = "sonar.ts.lcov.it.reportpath";

  public List getExtensions() {
    return Arrays.asList
      (
        TypeScriptRuleProfile.class,
        TypeScriptLanguage.class,
        TsLintSensor.class,
        LOCSensor.class,
        ITCoverageSensor.class,
        UTCoverageSensor.class,
        OverallCoverageSensor.class,
        TsRulesDefinition.class
      );
  }
}
